package org.pilgrim.finantial.processor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.pilgrim.finantial.model.TransactModel;

public class FMProcessorBankAmerica extends FMProcessor {

    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    
    @Override
    protected String[] getHeaders() {
        return new String[] { "Posted Date", "Reference Number", "Payee", "Address", "Amount" };
    }

    @Override
    protected String getBankName() {
        return "BankAmerica";
    }
    
    @Override
    public List<TransactModel> process(File file) {
        List<TransactModel> list = new ArrayList<>();

        try (final Reader reader = new FileReader(file);
                final CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());) {
            parser.forEach(record -> {
                TransactModel model = createTransactModel();
                model.setBankName(getBankName());
                model.setTransactionDate(toDate(record.get(0), sdf));
                model.setPostedDate(toDate(record.get(0), sdf));
                model.setDescription(record.get(2));
                String amount = record.get(4);
                if(null != amount && amount.startsWith("-")) {
                    model.setCredit(toBigDecimal(amount));
                } else if(null != amount) {
                    model.setDebit(toBigDecimal(amount));
                }
                list.add(model);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
