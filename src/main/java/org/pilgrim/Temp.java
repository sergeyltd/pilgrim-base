package org.pilgrim;

import java.util.Arrays;
import java.util.BitSet;

public class Temp {

    public static void main(String[] args) {

        System.out.println(licenseKeyFormatting("---fjgho--",4));
//        [-2147483648,1,2,3]
//                [1,-2147483648,-2147483648]
  //      System.out.println(Arrays.toString(intersect(new int[] {-2147483648, -2}, new int[] {-2147483648})));
    }
    
    public static String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase().replaceAll("-","");
        int n = S.length();
        int rem = n%K;
        
        StringBuilder sb = new StringBuilder();
        sb.append(S.substring(0, rem));
        
        int c = 0;
        for(int i=rem; i<n; i++){
            if(c%K==0 && sb.length() > 0){
                sb.append('-');
            }
            
            sb.append(S.charAt(i));
            c++;
                          
        }
        
        return sb.toString();
    }
    
    public static int[] intersect(int[] a, int[] b) {
        if(null == a  && null == b){
            return new int[0];
        }
        
        if(a.length > b.length){
            int[] t = a;
            a = b;
            b = t;
        }
        
        BitSet bs = new BitSet();
        BitSet mbs = new BitSet();
        for(int i : a){
            if(i >= 0) {
                bs.set(i);
            }
            else {
                mbs.set(i*(-1));
            }
        }
        
        int c = 0;
        int[] res = new int[a.length];
        for(int i : b){
            BitSet k = null;
            boolean neg = false;
            if (i >= 0) {
                k = bs;
            }
            else {
                k = mbs;
                i *= -1;
                neg = true;
            }
            if(k.get(i)){
                bs.clear(i);
                res[c++] = neg ? (i*(-1)) : i;
            }
        }
        
        return Arrays.copyOf(res, c);
    }
    
    public static long getUnsignedInt(int x) {
        return x & 0x00000000ffffffffL;
    }

}
