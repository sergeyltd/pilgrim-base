package org.pilgrim.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        
        if(cashe.containsKey(i) && cashe.get(i).containsKey(j)) {
            return cashe.get(i).get(j);
        }
        
        long fi1j = f(i-1,j);
        addToCashe(fi1j, i-1, j);
        
        long fi1j1 = f(i-1,j-1);
        addToCashe(fi1j1, i-1, j-1);

        return fi1j + fi1j1;
    }

    private void addToCashe(long val, long i, long j) {
        Map<Long, Long> rowCashe = cashe.get(i);
        if(null == rowCashe) {
            rowCashe = new HashMap<>();
            cashe.put(i, rowCashe);
        }
        
        rowCashe.put(j, val);
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        
        System.out.println(pt.f(500, 300));
    }

}
