package org.pilgrim.leetcode.y2020.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class CoddingWithALberto {

}




//Given a matrix of integers print out its values along the diagonals
//For example, given this matrix:

//{{1,  2,  3,  4},
//{5,  6,  7,  8},
//{9, 10, 11, 12}}

//The print out should be:

//1
//2 5
//3 6 9
//4 7 10
//8 11 
//12 



public class DiagonalMatrix{
public void printDiagonals(int[][] mat){
 if(mat == null || mat.length <= 0 || mat[0].legth <= 0){
   return;
 }
 
 int[][] a = mat;
 
 Map<Integer, List<Integer>> map = new LinkedHashMap<>();
 int n = a.length;
 int m = a[0].length;
 
 int d = 0;
 for(int i=0; i<n; i++){
   d = i;
   for(int j=0; j<m; j++){
     
     List<Integer> list  = map.get(d);
     if(list == null){
       list = new ArrayList<>();
       map.put(d, list);
     }
     
     list.add(a[i][j]);
     
     d++; 
   }
 }
 
 int f = 0;
 while(true){
   List<Integer> list = map.get(f);
   if(list == null){
     break;
   }
   print(list);
   f++;
 }
 
}

void print(List<Integer> list){
 // TODO: for connet condition
 
 for(Integer item : list){
   System.out.print(item + " ");
 }
 
 System.out.println();
}
}

dig = n + m - 1








//We have a list of various types of tasks to perform. Task types are identified with an identifier: task of type A, task of type B, task of type C, etc. Each task takes 1 second to execute, and once we have executed a task we need cooldown (parameter) period to recover before we can execute another task of the same type. However, we can execute tasks of other types in the meantime. The recovery interval is the same for all task types. We do not reorder the tasks: always execute in order in which we received them on input.
//Given a list of input tasks to run, and the cooldown interval, output the minimum amount of time required to run them.

//A A B A, t = 2
//A _ _ A B _ A, a = 7

//A A B C A, t = 2
//A _ _ A B C A, a = 7


//A A, t = 2
//A _ _ A, a = 4

//A A A, t = 2

public culculateTimeOut(List<Integer> tasks, int time){
if(tasks == null || tasks.isEmpty() || time >= 0){
 return 0;
}

int t = 0;
Map<Integer, Integer> map = new HashMap<>();

for(int i=0; i<tasks.size(); i++){
 
 Integer task = tasks.get(i);  // A, A
 
 int elp = 0; 
 Integer elTask = map.get(task);  // null, 3
 if(elTask != null){
   elp = elTask; // 3
   elTask = t + time + 1; // 1+2+1=4
 }
 else{
   elTask = t + time + 1;   // 0+2+1 = 3
 }
 
 map.put(task, elTask);  // A->3; A->4
 
 if(elp > t)  // 0>0; 3>1
 {
   t = t + (elp - t) + 1; // t = 1 + (2-1) = 2; 1+(3-1)
 }else{
   t++;   // t=1
 }
 
}


return t;  // 3
}




























