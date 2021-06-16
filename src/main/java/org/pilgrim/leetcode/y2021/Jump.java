package org.pilgrim.leetcode.y2021;

import java.util.ArrayList;
import java.util.List;

public class Jump {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(0);
        
        int t = jumpingOnClouds(list);
        System.out.println(t);

    }
    
    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        if(c == null || c.size() == 0){
            return 0;
        }
        
        // 6
        // 0 0 0 0 1 0
        
        int res = 0;
        System.out.println(res);
        for(int i=0; i<c.size() - 1;){
            if(i+2 < c.size() && c.get(i+2) == 0){
                i += 2;
                res++;
            }else if(i+1 < c.size() && c.get(i+1) == 0){
                i += 1;
                res++;
            }
        }
        
        return res;
    }

}
