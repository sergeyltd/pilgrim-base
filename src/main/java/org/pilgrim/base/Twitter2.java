package org.pilgrim.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;


public class Twitter2 {
    
    static class Feed implements Comparable<Feed> {
        public static final AtomicLong al = new AtomicLong(0);
        int id;
        long ts = al.incrementAndGet();

        public Feed(int id) {
            this.id = id;
            TreeMap t;
            t.pollFirstEntry()
        }
        
        public String toString(){
            return ""+id;
        }

        public int getId() {
            return id;
        }

        @Override
        public int compareTo(Feed o) {
            return Long.compare(o.ts, ts);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + id;
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
            Feed other = (Feed) obj;
            if (id != other.id)
                return false;
            return true;
        }
    }


    Map<Integer, Set<Integer>> followers = new HashMap<>();
    Map<Integer, LinkedList<Feed>> tweets = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter2() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        LinkedList<Feed> listFeeds = tweets.get(userId);
        if (listFeeds == null) {
            listFeeds = new LinkedList<>();
            tweets.put(userId, listFeeds);
        }
        listFeeds.add(new Feed(tweetId));
        while (listFeeds.size() > 10) {
            listFeeds.removeFirst();
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
     * the news feed must be posted by users who the user followed or by the user
     * herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Set<Feed> feeds = new TreeSet<>();
        LinkedList<Feed> listFeeds = tweets.get(userId);
        if (listFeeds != null) {
            feeds.addAll(listFeeds);
            System.out.println(listFeeds.iterator().next());
        }

        Set<Integer> listFollowers = followers.get(userId);
        if (listFollowers != null) {
            for (Integer flId : listFollowers) {
                listFeeds = tweets.get(flId);
                if (listFeeds != null) {
                    feeds.addAll(listFeeds);
                    System.out.println(listFeeds.iterator().next());
                }
            }
        }

        List<Integer> resList = new ArrayList<>(10);
        Iterator<Feed> iterator = feeds.iterator();
        int c = 0;
        while (iterator.hasNext() && c < 10) {
            c++;
            Feed feed = iterator.next();
            resList.add(feed.getId());
        }
        return resList;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> listFollowers = followers.get(followerId);
        if (listFollowers == null) {
            listFollowers = new HashSet<>();
            followers.put(followerId, listFollowers);
        }
        listFollowers.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> listFollowers = followers.get(followerId);
        if (listFollowers != null) {
            listFollowers.remove(followeeId);
            if (listFollowers.isEmpty()) {
                followers.remove(followerId);
            }
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */