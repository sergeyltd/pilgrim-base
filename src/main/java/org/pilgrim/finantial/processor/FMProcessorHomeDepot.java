package org.pilgrim.finantial.processor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.pilgrim.finantial.model.TransactModel;

public class FMProcessorHomeDepot extends FMProcessor {

    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    
    @Override
    protected int getPriority() {
        return super.getPriority() + 100;
    }
    
    @Override
    protected String[] getHeaders() {
        return new String[0];
    }
    
    @Override
    protected String getBankName() {
        return "Homedepot";
    }
    
    @Override
    public boolean canProcess(File file) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
            return lines.stream().filter(c->c.toLowerCase().contains("the home depot")).findAny().isPresent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public List<TransactModel> process(File file) {
        List<TransactModel> list = new ArrayList<>();

        try (final Reader reader = new FileReader(file);
                final CSVParser parser = new CSVParser(reader, CSVFormat.TDF);) {
            parser.forEach(record -> {
                TransactModel model = createTransactModel();
                model.setBankName(getBankName());
                model.setTransactionDate(toDate(record.get(0), sdf));
                model.setPostedDate(toDate(record.get(0), sdf));
                model.setDescription(record.get(2));
                String amount = record.get(1);
                if(null != amount && amount.contains("-")) {
                    model.setDebit(toBigDecimal(amount));
                } else if(null != amount) {
                    model.setCredit(toBigDecimal(amount));
                }
                list.add(model);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
