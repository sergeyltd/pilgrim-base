package org.pilgrim.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

public class Twitter
{

    public static class Node implements Comparable<Node>
    {
        public static final AtomicLong al = new AtomicLong(0);
        int                            id;
        long                           ts = al.incrementAndGet();

        public Node(int id)
        {
            this.id = id;
        }

        public int getId()
        {
            return id;
        }

        @Override
        public int compareTo(Node o)
        {
            return Long.compare(o.ts, ts);
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + id;
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Node other = (Node) obj;
            if (id != other.id)
                return false;
            return true;
        }
    }

    Map<Integer, Set<Node>>    map       = new LinkedHashMap<>();
    Map<Integer, Set<Integer>> mapFollow = new LinkedHashMap<>();

    /** Initialize your data structure here. */
    public Twitter()
    {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId,
                          int tweetId)
    {
        Set<Node> list = map.get(userId);
        if (null == list)
        {
            list = new TreeSet<>();
            map.put(userId, list);
        }
        Node node = new Node(tweetId);
        list.add(node);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId)
    {
        Set<Node> tpm = new TreeSet<>();
        Set<Node> list = map.get(userId);
        if (null != list)
        {
            tpm.addAll(list);
        }

        Set<Integer> set = mapFollow.get(userId);
        if (null != set)
        {
            for (Integer followeeId : set)
            {
                Set<Node> list2 = map.get(followeeId);
                if (null != list2)
                {
                    tpm.addAll(list2);
                }
            }
        }

        List<Integer> resList = new ArrayList<>(10);
        Iterator<Node> iterator = tpm.iterator();
        int c = 0;
        while (iterator.hasNext() && c < 10)
        {
            c++;
            Twitter.Node node = (Twitter.Node) iterator.next();
            resList.add(node.getId());
        }
        return resList;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId,
                       int followeeId)
    {
        Set<Integer> set = mapFollow.get(followerId);
        if (null == set)
        {
            set = new HashSet<>();
            mapFollow.put(followerId, set);
        }
        set.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId,
                         int followeeId)
    {
        Set<Integer> set = mapFollow.get(followerId);
        if (null != set)
        {
            set.remove(followeeId);
        }
    }

    public static void main(String[] args)
    {
        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        twitter.getNewsFeed(1);

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.getNewsFeed(1);

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        twitter.getNewsFeed(1);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */