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

public class FMProcessorCapitalOne extends FMProcessor {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected String[] getHeaders() {
        return new String[] { "Transaction Date", "Posted Date", "Card No.", "Description", "Category", "Debit",
                "Credit" };
    }

    @Override
    protected String getBankName() {
        return "CapitalOne";
    }

    @Override
    public List<TransactModel> process(File file) {
        List<TransactModel> list = new ArrayList<>();

        try (final Reader reader = new FileReader(file);
                final CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());) {
            parser.forEach(record -> {
                if (record.isConsistent()) {
                    TransactModel model = createTransactModel();
                    model.setBankName(getBankName());
                    model.setTransactionDate(toDate(record.get(0), sdf));
                    model.setPostedDate(toDate(record.get(1), sdf));
                    model.setCardInfo(record.get(2));
                    model.setDescription(record.get(3));
                    model.setCategory(record.get(4));
                    model.setDebit(toBigDecimal(record.get(6)));
                    model.setCredit(toBigDecimal(record.get(5)));
                    list.add(model);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
