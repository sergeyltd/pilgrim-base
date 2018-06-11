package org.pilgrim.finantial;

import static java.math.BigDecimal.ROUND_DOWN;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
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
import org.pilgrim.finantial.processor.FMProcessorChase2;
import org.pilgrim.finantial.processor.FMProcessorCiti;
import org.pilgrim.finantial.processor.FMProcessorHomeDepot;

import com.google.gson.reflect.TypeToken;

public class FMService {

    private String path;
    private Set<FMProcessor> processors = new HashSet<>(Arrays.asList(
            new FMProcessor[] { new FMProcessorCapitalOne(), new FMProcessorBankAmerica(), new FMProcessorChase(),
                    new FMProcessorCiti(), new FMProcessorHomeDepot(), new FMProcessorChase2() }));

    private FMService(String path) {
        this.path = path;
    }

    public static FMService newInstance() {
        return new FMService("C:\\Users\\segoncha\\Downloads\\fin\\2018");
    }

    public void load() {
        File root = new File(path);
        File[] listFiles = root.listFiles(pathname -> pathname.getName().toLowerCase().endsWith(".csv"));
        processFiles(listFiles);
    }

    private void processFiles(File[] listFiles) {
        Set<TransactModel> list = Collections.synchronizedSet(new HashSet<>());
        for (File file : listFiles) {
            Optional<FMProcessor> optional = processors.stream().sorted().filter(pr -> pr.canProcess(file)).findFirst();
            if (optional.isPresent()) {
                list.addAll(optional.get().process(file));
            }
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
            // System.out.println(model);
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
        System.out.println("========================================");
        {
            Map<Object, Double> map2 = list.stream().collect(Collectors.groupingBy(x -> {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(x.getTransactionDate());
                return calendar.get(YEAR);
            }, Collectors.summingDouble(x -> x.getDebit().doubleValue())));

            Set<Entry<Object, Double>> entrySet = map2.entrySet();

            for (Entry<Object, Double> entry : entrySet) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        System.out.println("========================================");
        {
            Map<Object, Map<Object, Double>> map2 = list.stream().collect(Collectors.groupingBy(x -> {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(x.getTransactionDate());
                return calendar.get(YEAR);
            }, Collectors.groupingBy(x -> x.getCategory(),
                    Collectors.summingDouble(x -> x.getCredit().doubleValue()))));

            Set<Entry<Object, Map<Object, Double>>> entrySet = map2.entrySet();

            for (Entry<Object, Map<Object, Double>> entry : entrySet) {
                System.out.println(entry.getKey());
                Map<Object, Double> value = entry.getValue();

                Set<Entry<Object, Double>> entrySet2 = value.entrySet();
                for (Entry<Object, Double> entry2 : entrySet2) {
                    System.out.println("     " + entry2.getKey() + ": " + entry2.getValue());
                }
            }
        }
        System.out.println("========================================");
        {
            Map<Object, Map<Object, Map<Object, Double>>> map2 = list.stream()
                    .filter(x -> x.getCredit().doubleValue() > 0).collect(Collectors.groupingBy(x -> {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(x.getTransactionDate());
                        return calendar.get(YEAR);
                    }, Collectors.groupingBy(x -> {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(x.getTransactionDate());
                        return calendar.get(MONTH);
                    }, Collectors.groupingBy(x -> x.getCategory(),
                            Collectors.summingDouble(x -> x.getCredit().doubleValue() * 100 / 100)))));

            String json = GsonHelper.toJson(map2);
            System.out.println(json);

        }
        System.out.println("========================================");
        {
            Map<Object, Map<Object, Map<Object, List<TransactModel>>>> map2 = list.stream()
                    .filter(x -> x.getCredit().doubleValue() > 0).collect(Collectors.groupingBy(x -> {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(x.getTransactionDate());
                        return calendar.get(YEAR);
                    }, Collectors.groupingBy(x -> {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(x.getTransactionDate());
                        return calendar.get(MONTH);
                    }, Collectors.groupingBy(x -> x.getCategory(), Collectors.toList()))));

            String json = GsonHelper.toJson(map2);
            System.out.println(json);

        }
        System.out.println("========================================");
        // System.out.println("========================================");
        // {
        // list.forEach(System.out::println);
        // }

        System.err.println(new BigDecimal(12770.00000001).setScale(2, ROUND_DOWN).doubleValue());
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
