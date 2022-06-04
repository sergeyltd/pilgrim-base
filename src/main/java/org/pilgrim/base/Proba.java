package org.pilgrim.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Proba {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        Arrays.binarySearch(a, key);
        Sides t1 = new Sides(1, 2, 3);
        Sides t2 = new Sides(1, 2, 3);
        
        Triangle tr1 = new Triangle(t1);
        Triangle tr2 = new Triangle(t2);
        
        Set<Triangle> s = new HashSet<>();
        s.add(tr1);
        s.add(tr2);
        
        System.out.println(s.size());
        System.out.println(tr1.compareTo(tr2));
    }
    
    static class Sides{
        int a;
        int b;
        int c;
        Sides(int a,int b,int c){
          this.a = a;
          this.b = b;
          this.c = c; 
        }
      }
      
      static class Triangle implements Comparable<Triangle>, Comparator<Triangle> {
        int[] sides = new int[3];
        Triangle(Sides sides){
          this.sides[0] = sides.a;
          this.sides[1] = sides.b;
          this.sides[2] = sides.c;
          
          Arrays.sort(this.sides);
        }
        
        public int compareTo(Triangle o) {
            int res = Integer.compare(this.sides[0], o.sides[0]);
            if(res != 0){
              return res;
            }
          
            res = Integer.compare(this.sides[1], o.sides[1]);
            if(res != 0){
              return res;
            }
          
            res = Integer.compare(this.sides[2], o.sides[2]);
            if(res != 0){
              return res;
            }
          
            return res;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + Arrays.hashCode(sides);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Triangle)) {
                return false;
            }
            Triangle other = (Triangle) obj;
            return Arrays.equals(sides, other.sides);
        }
        
        
      }
      
      // Add any helper functions you may need here
      
      
      int countDistinctTriangles(ArrayList<Sides> arr) {
        // Write your code here
        // Validate input data
        if(arr == null || arr.isEmpty()){
          return 0;
        }
        
        // Find distinct triangles
        Set<Triangle> trs = new HashSet<Triangle>();
        for(Sides s : arr){
          trs.add(new Triangle(s));
        }
        
        return trs.size();
      }

}

