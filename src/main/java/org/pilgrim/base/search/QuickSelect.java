package org.pilgrim.base.search;

public class QuickSelect {
    public int findKth(int[] a, int k) {
        if (null == a || a.length < k || k <= 0) {
            throw new IllegalArgumentException();
        }
        int j = findKth(a, 0, a.length - 1, k);
        return a[j];
    }

    private int findKth(int[] a, int lo, int hi, int k) {
        if (hi <= lo)
            return lo;
        int j = partition(a, lo, hi);
        if (k < j + 1) {
            j = findKth(a, lo, j - 1, k);
        } else if (k > j + 1) {
            j = findKth(a, j + 1, hi, k);
        }
        return j;
    }

    private int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int p = a[lo];

        while (true) {
            while (a[++i] < p) {
                if (i >= hi) {
                    break;
                }
            }

            while (p < a[--j]) {
                if (j <= lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            swap(a, i, j);
        }

        swap(a, lo, j);

        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
