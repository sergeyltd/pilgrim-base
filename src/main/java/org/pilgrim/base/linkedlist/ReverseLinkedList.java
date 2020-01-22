package org.pilgrim.base.linkedlist;

import org.pilgrim.base.linkedlist.SwapNodeInPairs.ListNode;

public class ReverseLinkedList {

    private ListNode _reverseList(ListNode head) {
        if (null == head.next) {
            return head;
        }

        ListNode newHead = _reverseList(head.next);
        if (null != newHead) {
            newHead.next = head;
            head.next = null;
        }

        return head;
    }

    private ListNode getTail(ListNode head) {
        if (null == head.next) {
            return head;
        }

        return getTail(head.next);
    }

    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return head;
        }

        ListNode tail = getTail(head);
        _reverseList(head);

        return tail;
    }

    public ListNode reverseList_rec(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode reverseList_it(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    
    public ListNode mergeTwoLists_rec(ListNode l1, ListNode l2) {
        if(null == l1){
            return l2;
        }
        
        if(null == l2){
            return l1;
        }
        
        if(l1.val < l2.val){
            l1.next = mergeTwoLists_rec(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists_rec(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 2, 3, 4 };

        ListNode head = new ListNode(arr[0]);
        ListNode node = head;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }

        node = head;
        while (null != node) {
            System.out.print("[" + node.val + "],");
            node = node.next;
        }
        System.out.println();

        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode tail = rll.reverseList(head);

        while (null != tail) {
            System.out.print("[" + tail.val + "],");
            tail = tail.next;
        }

        // Iterative
        System.out.println();

        head = new ListNode(arr[0]);
        node = head;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }

        ListNode newHead = rll.reverseList_it(head);

        while (null != newHead) {
            System.out.print("[" + newHead.val + "],");
            newHead = newHead.next;
        }

        // Recursive
        System.out.println();

        head = new ListNode(arr[0]);
        node = head;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }

        newHead = rll.reverseList_rec(head);

        while (null != newHead) {
            System.out.print("[" + newHead.val + "],");
            newHead = newHead.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
