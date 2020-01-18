package org.pilgrim.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.StopWatch;

public class PascalTriangle {

    // Pascal's Triangle recurrence calculation

    private Map<Long, Map<Long, Long>> cashe = new HashMap<>();

    /**
     * First of all, we define a function f(i, j) f(i,j) which returns the number in
     * the Pascal's Triangle in the i-th row and j-th column.
     * 
     * @param i
     * @param j
     */
    public long f(long i, long j) {
        if (i <= 0 || j <= 0) {
            return 0;
        }

        if (j == 1 || j == i) {
            return 1;
        }

        if (cashe.containsKey(i) && cashe.get(i).containsKey(j)) {
            return cashe.get(i).get(j);
        }

        long fi1j = f(i - 1, j);
        addToCashe(fi1j, i - 1, j);

        long fi1j1 = f(i - 1, j - 1);
        addToCashe(fi1j1, i - 1, j - 1);

        return fi1j + fi1j1;
    }

    public List<List<Integer>> generate_leetcode(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public List<List<Long>> generate(int numRows) {
        List<List<Long>> triangle = new LinkedList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Long> row = new ArrayList<>(i);
            triangle.add(row);

            for (int j = 1; j <= i; j++) {
                row.add(f(i, j));
            }
        }

        return triangle;
    }

    private void addToCashe(long val, long i, long j) {
        Map<Long, Long> rowCashe = cashe.get(i);
        if (null == rowCashe) {
            rowCashe = new HashMap<>();
            cashe.put(i, rowCashe);
        }

        rowCashe.put(j, val);
    }
    
    public List<Long> getRow(int rowIndex) {
        List<Long> list = new ArrayList<>(rowIndex + 1);
        int i = rowIndex + 1;
        for(int j=1; j<=i; j++){
            list.add(f(i,j));
        }
        return list;
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();

//        System.out.println(pt.f(10, 5));
        
        int numRows = 1000;
        StopWatch sw = new StopWatch();
        sw.start();
        pt.generate_leetcode(numRows);
        sw.stop();
        System.out.println(sw.getTime());
        
        sw = new StopWatch();
        sw.start();
        pt.generate(numRows);
        sw.stop();
        System.out.println(sw.getTime());

        List<List<Long>> tr = pt.generate(2);
        for (List<Long> row : tr) {
            for (Long item : row) {
                System.out.print("[" + item + "],");
            }
            System.out.println();
        }
    }

}
