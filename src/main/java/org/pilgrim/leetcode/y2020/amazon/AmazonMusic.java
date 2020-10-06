package org.pilgrim.leetcode.y2020.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonMusic {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(10);
        list.add(50);
        list.add(90);
        list.add(30);
        
        getSongPairCount(list);
    }

    public static long getSongPairCount(List<Integer> songs) {
        if (songs == null || songs.isEmpty() || songs.size() > 100000) {
            return 0;
        }

        long res = 0;

        // remainder, count
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < songs.size(); i++) {
            int song = songs.get(i);
            if (song < 1 || song > 1000) {
                return 0;
            }

            int sr = song % 60;
            Integer count = map.get(sr);

            if (count == null) {
                count = 0;
            }
            count++;

            map.put(sr, count);
        }

        for (int i = 0; i < songs.size(); i++) {
            int sr = songs.get(i) % 60;
            Integer count = map.get(sr);
            count--;
            if (count == 0) {
                map.remove(sr);
            }
            else {
                map.put(sr,  count);
            }

            // looking for this reminder in the map
            int lR = 60 - sr;
            if (lR == 60) {
                lR = 0;
            }

            if (map.get(lR) != null) {
                res += map.get(lR);
            }
        }

        return res;
    }
}
