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

public class FMProcessorCiti extends FMProcessor {

    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    @Override
    protected String[] getHeaders() {
        // return new String[] { "Details", "Posting Date", "Description", "Amount",
        // "Type", "Balance",
        // "Check or Slip #" };

        return new String[] { "Status", "Date", "Description", "Debit", "Credit", "Member Name" };
    }

    @Override
    protected String getBankName() {
        return "Citi";
    }

    @Override
    public List<TransactModel> process(File file) {
        List<TransactModel> list = new ArrayList<>();

        try (final Reader reader = new FileReader(file);
                final CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());) {
            parser.forEach(record -> {
                if ("Cleared".equals(record.get(0))) {
                    TransactModel model = createTransactModel();
                    model.setBankName(getBankName());
                    model.setTransactionDate(toDate(record.get(1), sdf));
                    model.setPostedDate(toDate(record.get(1), sdf));
                    model.setDescription(record.get(2));
                    model.setDebit(toBigDecimal(record.get(3)));
                    model.setCredit(toBigDecimal(record.get(4)));
                    list.add(model);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
