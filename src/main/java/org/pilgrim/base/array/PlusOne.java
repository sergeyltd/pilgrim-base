package org.pilgrim.base.array;

import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length <= 0) {
            return digits;
        }

        int[] d = digits;
        int n = d.length - 1;

        // carry
        int c = 1;
        for (int i = n; i >= 0; i--) {
            d[i] += c;
            if (d[i] > 9) {
                c = d[i] / 10;
                d[i] = d[i] % 10;
            } else {
                c = 0;
                break;
            }
        }

        if (c > 0) {
            int[] nd = new int[n + 2];
            nd[0] = c;
            for (int i = 0; i < n; i++) {
                nd[i + 1] = d[i];
            }
            return nd;
        }

        return d;
    }

    public static void main(String[] args) {
        int[] d = {1,2,9};
        int[] a = plusOne(d);
        System.out.println(Arrays.toString(a));
    }
}
