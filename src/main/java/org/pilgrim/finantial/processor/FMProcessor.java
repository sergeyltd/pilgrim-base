package org.pilgrim.finantial.processor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.pilgrim.finantial.model.TransactModel;

public abstract class FMProcessor {

    private String id = this.getClass().getCanonicalName();

    private Set<String> getSupportedHeaders() {
        Set<String> list = new HashSet<>();
        for (String header : getHeaders()) {
            list.add(header.toLowerCase());
        }
        return list;
    }

    protected TransactModel createTransactModel() {
        TransactModel model = new TransactModel();
        model.setBankName(getBankName());
        return model;
    }

    abstract protected String getBankName();

    abstract protected String[] getHeaders();

    public boolean canProcess(File file) {
        try (final Reader reader = new FileReader(file);
                final CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());) {
            return parser.getHeaderMap().keySet().stream()
                    .allMatch(h -> getSupportedHeaders().contains(h.toLowerCase()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<TransactModel> process(File file) {
        return Collections.emptyList();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof FMProcessor)) {
            return false;
        }
        FMProcessor other = (FMProcessor) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    protected static Date toDate(String str, SimpleDateFormat sdf) {
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected static BigDecimal toBigDecimal(String val) {
        try {
            return new BigDecimal(val).abs();
        } catch (Exception e) {
        }
        return BigDecimal.ZERO;
    }

}
