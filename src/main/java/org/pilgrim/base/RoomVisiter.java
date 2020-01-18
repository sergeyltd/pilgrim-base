package org.pilgrim.base;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RoomVisiter {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        while(!q.isEmpty()){
            Integer room = q.poll();
            List<Integer> keys = rooms.get(room);
            for(Integer key : keys){
                if(!visited.contains(key)){
                    q.add(key);
                    visited.add(key);
                }
            }
        }
        
        return visited.size() == rooms.size();
    }
}