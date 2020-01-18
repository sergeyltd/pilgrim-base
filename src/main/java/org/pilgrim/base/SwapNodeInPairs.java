package org.pilgrim.base;

public class SwapNodeInPairs {

    public ListNode swapPairs(ListNode head) {
        return helper(head);
    }

    private ListNode helper(ListNode node) {
        if (null == node || null == node.next) {
            return node;
        }

        ListNode prevHead = helper(node.next.next);

        ListNode nextNode = node.next;
        nextNode.next = node;
        node.next = prevHead;

        return nextNode;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = new int[] {2,3,4};
        
        ListNode head = new ListNode(1);
        ListNode root = head;
        for (int i = 0; i < arr.length; i++) {
            root.next = new ListNode(arr[i]);
            root = root.next;
        }
        
        SwapNodeInPairs snp = new SwapNodeInPairs();
        ListNode newHead = snp.swapPairs(head);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
