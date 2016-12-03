package org.pilgrim.base;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder
{
    private Queue<Integer> minHeap = new PriorityQueue<>();
    private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    // Adds a number into the data structure.
    public void addNum(int num)
    {
        maxHeap.add(num);
        Integer poll = maxHeap.poll();
        minHeap.add(poll);
        if (minHeap.size() > maxHeap.size())
        {
            poll = minHeap.poll();
            maxHeap.add(poll);
        }
    }

    // Returns the median of current data stream
    public double findMedian()
    {
        if (maxHeap.size() > minHeap.size())
        {
            return maxHeap.peek().doubleValue();
        }
        else
        {
            return (maxHeap.peek().doubleValue() + minHeap.peek().doubleValue()) / 2d;
        }
    }
    
    public static void main(String[] args)
    {
        MedianFinder f = new MedianFinder();
        f.addNum(1);
        f.addNum(2);
        System.out.println(f.findMedian());
        f.addNum(3); 
        System.out.println(f.findMedian());
    }
};