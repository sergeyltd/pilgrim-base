package org.pilgrim.hiredintech;

import java.io.*;
import java.util.*;

public class Pairs {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        long[] a = new long[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextLong();
        }
        long c = 0;
        Arrays.sort(a);
        for(int i=0; i<n; i++){
            long df = 0;
            for(int j=i+1; j<n; j++){
                df = a[j]-a[i];
                if(df<k){
                    continue;
                }
                if(df==k){
                    c++;
                    break;
                }
                if(df>k)
                    break;
            }
        }
        System.out.println(c);
    }
}
