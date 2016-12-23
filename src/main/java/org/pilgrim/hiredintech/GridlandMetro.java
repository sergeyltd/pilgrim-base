package org.pilgrim.hiredintech;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class GridlandMetro
{

    public static class Track implements Comparable<Track>
    {
        long r;
        long c1;
        long c2;

        public boolean isInside(int c)
        {
            return c >= c1 && c <= c2;
        }

        public long length()
        {
            return Math.abs(c2 - c1 + 1);
        }

        public int compareTo(Track o)
        {
            return Long.compare(c1, o.c1);
        }
    }

    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();

        Map<Long, TreeMap<Long, Track>> map = new HashMap<>();
        for (long i = 0; i < k; i++)
        {
            long r = sc.nextLong() - 1L;

            Track track = new Track();
            track.r = r;
            track.c1 = sc.nextLong() - 1L;
            track.c2 = sc.nextLong() - 1L;

            Track prevTrack = null;
            TreeMap<Long, Track> list = map.get(r);
            if (null == list)
            {
                list = new TreeMap<>();
                map.put(r, list);
            }
            else
            {
                Map.Entry<Long, Track> entry = list.floorEntry(track.c1);
                if (null != entry)
                {
                    prevTrack = entry.getValue();
                }
            }

            if (null != prevTrack && prevTrack.c2 >= track.c1)
            {
                prevTrack.c2 = Math.max(track.c2, prevTrack.c2);
            }
            else
            {
                list.put(track.c1, track);
            }
        }
        sc.close();

        long lampposts = 0;
        for (long i = 0; i < n; i++)
        {
            TreeMap<Long, Track> list = map.get(i);
            lampposts += m;
            if (null == list)
            {
                continue;
            }
            Set<Entry<Long, Track>> entrySet = list.entrySet();
            for (Entry<Long, Track> entry : entrySet)
            {
                Track track = entry.getValue();
                lampposts -= track.length();
            }
        }

        System.out.println(lampposts);

    }
}
