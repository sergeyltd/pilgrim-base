package org.pilgrim.hiredintech;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class GridlandMetro2 {
    public static class Track implements Comparable<Track> {
        long c1;
        long c2;

        public long length() {
            return Math.abs(c2 - c1) + 1;
        }

        public int compareTo(Track o) {
            int res = Long.compare(c1, o.c1);
            return 0 == res ? Long.compare(c2, o.c2) : res;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (c1 ^ (c1 >>> 32));
            result = prime * result + (int) (c2 ^ (c2 >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Track other = (Track) obj;
            if (c1 != other.c1)
                return false;
            if (c2 != other.c2)
                return false;
            return true;
        }
    }

    public static long len(Track[] array){
        long s = 0;
        Arrays.sort(array);
        long lb = 0;
        for (Track track : array) {
            s += track.c1 >= lb ? track.length()
                    : (track.c2 >= lb ? track.c2 - lb + 1 : 0);
            lb = track.c2 + 1;
        }
        return s;        
    }
    public static long len2(Track[] array){
        Arrays.sort(array);
        Track trk = array[0];

        long a = trk.c1;
        long b = trk.c2;
        long s = 0;

        for (int i = 1; i<array.length; i++) {
            trk = array[i];
            if (trk.c1 <= b) {
                b = Math.max(b, trk.c2);
            }
            else {
                s += (b - a + 1);
                a = trk.c1;
                b = trk.c2;
            }
        }
        s += (b - a + 1);

        return s;
    }

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();

        long lampposts = n * m;

        Map<Long, Set<Track>> map = new HashMap<>();
        for (long i = 0; i < k; i++) {
            long r = sc.nextLong();

            Track track = new Track();
            track.c1 = sc.nextLong();
            track.c2 = sc.nextLong();

            Set<Track> list = map.get(r);
            if (null == list) {
                list = new HashSet<>();
                map.put(r, list);
            }

            list.add(track);
        }
        sc.close();

        long s = lampposts;
        Set<Entry<Long, Set<Track>>> entrySet = map.entrySet();
        for (Entry<Long, Set<Track>> entry : entrySet) {
            Track[] array = entry.getValue().toArray(new Track[entry.getValue().size()]);
            lampposts -= len(array); // there is a bug inside but i could not found it
            s -= len2(array);
        }
        System.out.println(lampposts);
        System.out.println(s);
    }
}

/**
4 4 3
2 2 3
3 1 4
4 4 4
9
=======
1 5 3
1 1 2
1 2 4
1 3 5
0
=======
2 9 3
2 1 5
2 2 4
2 8 8
11
=======
2 9 3
1 0 0
1 0 0
2 8 8
10
*/

/*
343959391703854850
*/