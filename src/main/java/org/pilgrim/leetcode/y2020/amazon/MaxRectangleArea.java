package org.pilgrim.leetcode.y2020.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;



public class MaxRectangleArea {

    public static void main(String[] args) {
        List<Boolean> isV = new ArrayList<>();
        isV.add(false);
        isV.add(true);
        
        List<Integer> dist = new ArrayList<>();
        dist.add(1);
        dist.add(1);
        
        List<Long> ar = getMaxArea(2, 2, isV, dist);
        for (Long a : ar) {
            System.out.println(a);
        }
    }
    
    
        /*
         * Complete the 'getMaxArea' function below.
         *
         * The function is expected to return a LONG_INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER w
         *  2. INTEGER h
         *  3. BOOLEAN_ARRAY isVertical
         *  4. INTEGER_ARRAY distance
         */
         
        public static class Rect implements Comparable<Rect>{
            public int x0;
            public int y0;
            public int xn;
            public int yn;
            public Rect(int x0, int xn, int y0, int yn){
                this.x0 = x0;
                this.y0 = y0;
                this.xn = xn;
                this.yn = yn;
            }
            
            public int compareTo(Rect t){
                return Long.compare(this.Area(), t.Area());
            }
            
            public long Area(){
                return (long) Math.abs(xn-x0)*Math.abs(yn-y0);
            }
            
            public String toString(){
                return "x0=" + x0+", xn="+xn+", y0="+y0+", yn="+yn+", area="+this.Area();
            }
            
            public List<Rect> Split(boolean isVert, int dist){
                List<Rect> res = new ArrayList<>();
                
                if(isVert){
                    if(dist > x0 && dist < xn){
                        res.add(new Rect(x0, dist, y0, yn));
                        res.add(new Rect(dist, xn, y0, yn));
                    }
                    else{
                        res.add(this);
                    }
                }else{
                    if(dist > y0 && dist < yn){
                        res.add(new Rect(x0, xn, y0, dist));
                        res.add(new Rect(x0, xn, dist, yn));
                    }
                    else{
                        res.add(this);
                    }
                }
                
                return res;
            }
        }

        public static List<Long> getMaxArea(int w, int h, List<Boolean> isVertical, List<Integer> distance) {
        // Write your code here
            List<Long> res = new ArrayList<>();
            if (w < 2 || h < 2 || w > 100000 || h > 100000 || isVertical == null || isVertical.isEmpty() || distance == null || distance.isEmpty() || isVertical.size() != distance.size()) {
                return res;
            }
            
            PriorityQueue<Rect> queue = new PriorityQueue<>(Collections.reverseOrder());
            queue.add(new Rect(0, w, 0, h));
            
            for (int i = 0; i < isVertical.size(); i++) {
                boolean isV = isVertical.get(i);
                int d = distance.get(i);
                
                List<Rect> splitedRects = new ArrayList<>();
                while(!queue.isEmpty()) {
                    Rect r = queue.poll();
                    List<Rect> list = r.Split(isV, d);
                    for(Rect rr: list){
                        System.out.println(rr);
                    }
                    
                    splitedRects.addAll(list);
                }
                
                queue.addAll(splitedRects);
                
                System.out.println("Peek: " +queue.peek());
                
                res.add(queue.peek().Area());
            }
            
            return res;
        }
}
