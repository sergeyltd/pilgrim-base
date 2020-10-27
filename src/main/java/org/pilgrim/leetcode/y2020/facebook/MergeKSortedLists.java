package org.pilgrim.leetcode.y2020.facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class Node {
        int index;
        int val;

        Node() {
        }

        Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }

        ListNode res = new ListNode();
        ListNode head = res;

        PriorityQueue<Node> pr = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for (int i = 0; i < lists.length; i++) {
            ListNode m = lists[i];
            if (m == null) {
                continue;
            }

            pr.add(new Node(i, m.val));
            lists[i] = m.next;
        }

        while (!pr.isEmpty()) {
            Node node = pr.poll();
            res.next = new ListNode(node.val);
            res = res.next;

            ListNode ln = lists[node.index];
            if (ln != null) {
                pr.add(new Node(node.index, ln.val));
                lists[node.index] = ln.next;
            }
        }

        return head.next;
    }
}
