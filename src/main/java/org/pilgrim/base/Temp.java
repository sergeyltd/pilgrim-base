package org.pilgrim.base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Temp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        a = Arrays.asList(new String[] {"1"}).stream().map(Integer::parseInt).;
    }
    
    public int openLock(String[] deadends, String target) {
        if(target == null || target.length() != 4 || deadends == null){
            return -1;
        }
        Set<Integer> deads = new HashSet<>(Arrays.asList(deadends).stream().map(Integer::parseInt).collect(Collectors.toList()));
        Set<Integer> visited = new HashSet<>();
        Integer tar = Integer.parseInt(target);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0000);
        int step = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Integer cur = q.poll();
                
                if(tar.equals(cur)){
                    return step;
                }
                
                if(deads.contains(cur)){
                   continue; 
                }
                
                for(int j=0; j<4; j++){
                    for(int k=-1; k<=1; k+=2){
                        int d10 = (int)Math.pow(10,j);
                        int d100 = d10*10;
                        int p = (d10*k + d100)%d100;
                        Integer ch = cur + p;
                        if(!visited.contains(ch)){
                            visited.add(ch);
                            q.add(ch);
                        }                       
                    }
                }
            }
            step++;
        }
        
        return -1;
    }

}
