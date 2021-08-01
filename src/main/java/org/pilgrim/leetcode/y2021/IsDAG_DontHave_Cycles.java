package org.pilgrim.leetcode.y2021;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsDAG_DontHave_Cycles {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    Set<Integer> vis = new HashSet<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            return false;
        }
        
        if(prerequisites.length <= 0){
            return true;
        }
        
        Set<Integer> prevS = new HashSet<>();
        Set<Integer> nextS = new HashSet<>();
        
        int n = prerequisites.length;
        for(int i=0; i<n; i++){
            int prevCour = prerequisites[i][1];
            int nextCour = prerequisites[i][0];
            
            prevS.add(prevCour);
            nextS.add(nextCour);
            
            Set<Integer> courses = map.get(prevCour);
            if(courses == null){
                courses = new HashSet<>();
                map.put(prevCour, courses);
            }
            
            courses.add(nextCour);
        }
        
        prevS.removeAll(nextS);
        
        for(Integer item : prevS){
            if(!dfs(item)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(Integer node){
        if(node == null){
            return true;
        }
        
        if(vis.contains(node)){
            return false;
        }
        
        vis.add(node);
        
        Set<Integer> courses = map.get(node);
        if(courses != null){
            for(Integer n : courses){
                if(!dfs(n)){
                    return false;
                }
            }
        }
        
        vis.remove(node);
        
        return true;
    }
}