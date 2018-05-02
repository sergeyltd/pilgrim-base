package org.pilgrim.finantial;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.pilgrim.finantial.model.TransactModel;
import org.pilgrim.finantial.processor.DecisionMaker;
import org.pilgrim.finantial.processor.FMProcessor;
import org.pilgrim.finantial.processor.FMProcessorBankAmerica;
import org.pilgrim.finantial.processor.FMProcessorCapitalOne;
import org.pilgrim.finantial.processor.FMProcessorChase;
import org.pilgrim.finantial.processor.FMProcessorCiti;

import com.google.gson.reflect.TypeToken;

public class FMService {

    private String path;
    private Set<FMProcessor> processors = new HashSet<>(Arrays.asList(new FMProcessor[] { new FMProcessorCapitalOne(),
            new FMProcessorBankAmerica(), new FMProcessorChase(), new FMProcessorCiti() }));

    private FMService(String path) {
        this.path = path;
    }

    public static FMService newInstance() {
        return new FMService("C:\\Users\\segoncha\\Downloads\\fin\\2017");
    }

    public void load() {
        File root = new File(path);
        File[] listFiles = root.listFiles(pathname -> pathname.getName().toLowerCase().endsWith(".csv"));
        processFiles(listFiles);
    }

    private void processFiles(File[] listFiles) {
        List<TransactModel> list = Collections.synchronizedList(new ArrayList<>());
        for (File file : listFiles) {
            List<FMProcessor> procs = processors.stream().filter(pr -> pr.canProcess(file))
                    .collect(Collectors.toList());
            procs.forEach(pr -> list.addAll(pr.process(file)));
        }

        List<TransactModel> dataForTraining = list.stream().filter(
                item -> StringUtils.isNotBlank(item.getCategory()) /* && item.getDebit().equals(BigDecimal.ZERO) */)
                .collect(Collectors.toList());

        DecisionMaker dm = new DecisionMaker();
        dm.training(dataForTraining.toArray(new TransactModel[0]));

        List<TransactModel> correctionModels = getCorrectionModels();
        dm.training(correctionModels.toArray(new TransactModel[0]));

        // int index = 0;
        // for (TransactModel transactModel : dataForTraining) {
        // System.out.println((++index) + ". " + transactModel.getDescription());
        // }

        List<TransactModel> dataWithoutCategory = list.stream().filter(
                item -> StringUtils.isBlank(item.getCategory()) /* && item.getDebit().equals(BigDecimal.ZERO) */)
                /* .filter(distinctByKey(p -> p.getDescription())) */.collect(Collectors.toList());

        for (TransactModel model : dataWithoutCategory) {
            String category = dm.predict(model);
            model.setCategory(category);
            System.out.println(model);
        }

        // Map<String, TransactModel> map =
        // list.stream().collect(Collectors.toMap(x->x.getCategory(), x->x));

        {
            Map<Object, Double> map2 = list.stream().collect(Collectors.groupingBy(x -> x.getCategory(),
                    Collectors.summingDouble(x -> x.getCredit().doubleValue())));

            Set<Entry<Object, Double>> entrySet = map2.entrySet();

            for (Entry<Object, Double> entry : entrySet) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        System.out.println("========================================");
        {
            Map<Object, Double> map2 = list.stream().collect(Collectors.groupingBy(x -> x.getCategory(),
                    Collectors.summingDouble(x -> x.getDebit().doubleValue())));

            Set<Entry<Object, Double>> entrySet = map2.entrySet();

            for (Entry<Object, Double> entry : entrySet) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    private List<TransactModel> getCorrectionModels() {
        try {
            String content = FileUtils.readFileToString(new File(
                    "C:\\Users\\segoncha\\git\\pilgrim-base\\src\\main\\resources\\finantial\\corrections.json"),
                    Charset.forName("UTF-8"));
            Type listType = new TypeToken<ArrayList<TransactModel>>() {
            }.getType();
            return GsonHelper.fromJson(content, listType);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> ke) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(ke.apply(t), Boolean.TRUE) == null;
    }
}
