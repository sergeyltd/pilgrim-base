package org.pilgrim.hiredintech;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class MissingNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        long nA = sc.nextLong();
        long c = 0;
        Map<Long,Long> mapA = new HashMap<>();
        while(c++<nA){
            long r = sc.nextLong();
            Long curr = mapA.get(r);
            if(null == curr){
                curr = 0L;
            }
            curr++;
            mapA.put(r, curr);
        }
        
        long nB = sc.nextLong();
        c = 0;
        Map<Long,Long> mapB = new HashMap<>();
        while(c++<nB){
            long r = sc.nextLong();
            Long curr = mapB.get(r);
            if(null == curr){
                curr = 0L;
            }
            curr++;
            mapB.put(r, curr);
        }
        sc.close();

        Queue<Long> heap = new PriorityQueue<>();
        Set<Entry<Long,Long>> entrySet = mapA.entrySet();
        for (Entry<Long, Long> entry : entrySet) {
            Long currA = entry.getKey();
            Long countA = entry.getValue();
            Long countB = mapB.remove(currA);
            if(countB != countA){
                heap.add(currA);
            }
        }
        
        entrySet = mapB.entrySet();
        for (Entry<Long, Long> entry : entrySet) {
            Long currB = entry.getKey();
            heap.add(currB);
        }
        
        heap.forEach(item->System.out.print(item + " "));
    }
}
