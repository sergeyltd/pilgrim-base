package org.pilgrim.base.google;

import java.util.ArrayList;
import java.util.List;

public class Buff {

    /**
     * The read4 API is defined in the parent class Reader4. int read4(char[] buf);
     */

    private char[] buff = new char[4];
    private int st = 0;
    private int en = 0;

    /**
     * @param buf
     *            Destination buffer
     * @param n
     *            Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        List<Character> list = new ArrayList<>();
        try {
            int dif = en - st;

            if (dif >= n) {
                for (int i = 0; i < n; i++) {
                    buf[i] = buff[st++];
                }
                if (en == st) {
                    en = 0;
                    st = 0;
                }

                return n;
            } else if (dif > 0) {
                for (int i = 0; i < dif; i++) {
                    list.add(buff[st++]);
                }
                if (en == st) {
                    en = 0;
                    st = 0;
                }
                // n -= dif;
            }

            int la = dif;

            int c = (n - dif) / 4 + 1;
            for (int i = 0; i < c; i++) {
                char[] tbuff = new char[4];
                int a = read4(tbuff);
                for (int j = 0; j < a; j++) {
                    list.add(tbuff[j]);
                }
                if (a < 4) {
                    break;
                }
            }

            if (list.size() > n) {
                int d = list.size() - n;
                st = 0;
                en = d;
                for (int i = 0; i < d; i++) {
                    buff[i] = list.remove(n);
                }
            }

            for (int i = 0; i < list.size(); i++) {
                buf[i] = list.get(i);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        }

        return list.size();
    }

    private int read4(char[] tbuff) {
        return 1;
    }

    public static void main(String[] args) {
        Buff b = new Buff();
        
        char[] buf = new char[10];
        b.read(buf, 2);

    }

}
