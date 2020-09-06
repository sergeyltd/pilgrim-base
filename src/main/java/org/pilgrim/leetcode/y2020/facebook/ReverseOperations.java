package org.pilgrim.leetcode.y2020.facebook;

public class ReverseOperations {

    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    // Add any helper functions you may need here

    Node _reverse(Node a, Node en) {
        Node head = _reverse(a, a.next, en);
        a.next = null;
        return head;
    }

    Node _reverse(Node a, Node b, Node en) {
        if (b == null || a == en) {
            // this is new header
            return a;
        }

        Node head = _reverse(b, b.next, en);
        b.next = a;
        return head;
    }

    void print(Node root) {
        while (root != null) {
            System.out.print(root.data + ", ");
            root = root.next;
        }

        System.out.println();
    }

    Node reverse(Node head) {
        // Write your code here
        print(head);

        Node root = head;
        Node st = null;
        Node en = null;
        Node lastOdd = null;
        while (root != null) {

            if (st == null && root.data % 2 != 0) {
                lastOdd = root;
            }

            if (root.data % 2 == 0) {
                if (st == null) {
                    st = root;
                }
                en = root;
            } else if (st != null) {
                Node newHead = _reverse(st, en);
                st.next = root;
                if (lastOdd != null) {
                    lastOdd.next = newHead;
                } else {
                    head = newHead;
                }
                st = null;
                lastOdd = root;
            }

            root = root.next;
        }
        
        if(st != null) {
            Node newHead = _reverse(st, en);
            if (lastOdd != null) {
                lastOdd.next = newHead;
            } else {
                head = newHead;
            }
        }

        print(head);

        return head;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void printLinkedList(Node head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
            if (head != null)
                System.out.print(" ");
        }
        System.out.print("]");
    }

    void check(Node expectedHead, Node outputHead) {
        boolean result = true;
        Node tempExpectedHead = expectedHead;
        Node tempOutputHead = outputHead;
        while (expectedHead != null && outputHead != null) {
            result &= (expectedHead.data == outputHead.data);
            expectedHead = expectedHead.next;
            outputHead = outputHead.next;
        }
        if (!(expectedHead == null && outputHead == null))
            result = false;

        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printLinkedList(tempExpectedHead);
            System.out.print(" Your output: ");
            printLinkedList(tempOutputHead);
            System.out.println();
        }
        test_case_number++;
    }

    Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    public void run() {

        int[] arr_1 = { 1, 2, 8, 9, 12, 16 };
        int[] expected1 = { 1, 8, 2, 9, 16, 12 };
        Node head_1 = createLinkedList(arr_1);
        Node expected_1 = createLinkedList(expected1);
        Node output_1 = reverse(head_1);
        check(expected_1, output_1);

        int[] arr_2 = { 2, 18, 24, 3, 5, 7, 9, 6, 12 };
        int[] expected2 = { 24, 18, 2, 3, 5, 7, 9, 12, 6 };
        Node head_2 = createLinkedList(arr_2);
        Node expected_2 = createLinkedList(expected2);
        Node output_2 = reverse(head_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ReverseOperations().run();
    }
}
