package org.pilgrim.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    public int i;
    public int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class WallAndGates {
    static int INF = 2147483647;
    
    public static void main(String[] args) {
        int[][]rooms = 
                {{INF,-1, 0, INF},
                {INF,INF,INF,-1},
                {INF,-1,INF,-1},
                {0,-1,INF,INF}};
        WallAndGates w = new WallAndGates();
        w.wallsAndGates(rooms);
        
        print(rooms);
    }
    
    public static void print(int[][] rooms) {
        System.out.println("******************************");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rooms.length; i++) {
            List<String> list = new ArrayList<>(rooms[0].length);
            for (int j = 0; j < rooms[0].length; j++) {
                list.add(""+rooms[i][j]);                
            }
            sb.append(String.join(",", list)).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length <= 0 || rooms[0].length <= 0) {
            return;
        }

        doBfs(rooms, getDoors(rooms));
    }

    private List<Pair> getDoors(int[][] rooms) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    list.add(new Pair(i, j));
                }
            }
        }

        return list;
    }

    private void doBfs(int[][] rooms, List<Pair> doors) {
        // implement BFS with visited
        Queue<Pair> q = new LinkedList<>(doors);

        int step = 0;
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        
        for(Pair door : doors){
            visited[door.i][door.j] = true;    
        }
        
        while (!q.isEmpty()) {
            print(rooms);
            int size = q.size();
            for (int k = 0; k < size; k++) {
                print(rooms);
                Pair p = q.poll();
                int r = getRoom(rooms, p);
                if (isDoor(r)) {
                    List<Pair> directs = getAllDirections(rooms, p, visited);
                    for (Pair d : directs) {
                        q.add(d);
                    }
                } else if (isWall(r)) {
                    // skip
                } else if (isInf(r)) {
                    rooms[p.i][p.j] = step;
                    List<Pair> directs = getAllDirections(rooms, p, visited);
                    for (Pair d : directs) {
                        q.add(d);
                    }
                } else if (r > step) {
                    rooms[p.i][p.j] = step;
                    List<Pair> directs = getAllDirections(rooms, p, visited);
                    for (Pair d : directs) {
                        q.add(d);
                    }
                }
            }
            step++;
        }
    }

    private List<Pair> getAllDirections(int[][] rooms, Pair p, boolean[][] visited) {
        List<Pair> list = new ArrayList<>(4);
        int n = rooms.length;
        int m = rooms[0].length;

        if (p.i + 1 < n && !visited[p.i + 1][p.j]) {
            list.add(new Pair(p.i + 1, p.j));
            visited[p.i + 1][p.j] = true;
        }

        if (p.i - 1 >= 0 && !visited[p.i - 1][p.j]) {
            list.add(new Pair(p.i - 1, p.j));
            visited[p.i - 1][p.j] = true;
        }

        if (p.j + 1 < m && !visited[p.i][p.j + 1]) {
            list.add(new Pair(p.i, p.j + 1));
            visited[p.i][p.j + 1] = true;
        }

        if (p.j - 1 >= 0 && !visited[p.i][p.j - 1]) {
            list.add(new Pair(p.i, p.j - 1));
            visited[p.i][p.j - 1] = true;
        }

        return list;
    }

    private boolean isWall(int p) {
        return p == -1;
    }

    private boolean isInf(int p) {
        return p == INF;
    }

    private boolean isDoor(int p) {
        return p == 0;
    }

    private int getRoom(int[][] rooms, Pair p) {
        return rooms[p.i][p.j];
    }
}
