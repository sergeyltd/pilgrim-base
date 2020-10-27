package org.pilgrim.leetcode.y2020.amazon;

import java.util.Stack;

public class Sum2LinkedLists {

    public static void main(String[] args) {
        {
            Node n1 = numberToNode(5143);
            Node n2 = numberToNode(29);

            Node s = sum2(n1, n2);
            print(s);
        }
        {
            Node n1 = stringToNode("51475653543456890378744507533468754545786673453565668756453");
            Node n2 = stringToNode("29765788778587866545434566563453534546533423453467568779674543544578679868755632243465766877879996764564565324563");

            Node s = sum2(n1, n2);
            print(s);
        }

    }

    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void print(Node n) {
        while (n != null) {
            System.out.print(n.val);
            n = n.next;
        }

        System.out.println();
    }

    public static Node numberToNode(int a) {
        Node n = new Node(0);
        while (a > 0) {
            n.val = a % 10;
            Node temp = new Node(0);
            temp.next = n;
            n = temp;
            a = a / 10;
        }

        return n.next;
    }

    public static Node stringToNode(String a) {
        Node n = new Node(0);
        for (int i = a.length() - 1; i >= 0; i--) {
            int c = a.charAt(i) - '0';
            n.val = c % 10;
            Node temp = new Node(0);
            temp.next = n;
            n = temp;
        }

        return n.next;
    }

    // n1 = 5->1->4->3 (5143)
    // n2 = 2->9 (29)
    // res = 5->1->7->2 (5172)=29+5143

    public static Node sum2(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return null;
        }

        Node res = new Node(0);

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while (n1 != null || n2 != null) {
            if (n1 != null) {
                st1.add(n1.val);
                n1 = n1.next;
            }
            if (n2 != null) {
                st2.add(n2.val);
                n2 = n2.next;
            }
        }

        int carry = 0;
        while (!st1.isEmpty() || !st2.isEmpty()) {
            int a = (!st1.isEmpty() ? st1.pop() : 0) + (!st2.isEmpty() ? st2.pop() : 0) + carry;
            res.val = a % 10;
            carry = a / 10;
            Node temp = new Node(0);
            temp.next = res;
            res = temp;
        }

        return res.next;
    }

    public Node sum(Node n1, Node n2) {
        if (n1.next == null && n2.next == null) {
            int sum = n1.val = n2.val;

            Node root = new Node(sum);
            return root;
        }

        Node m1 = n1;
        Node m2 = n2;

        if (n1.next != null) {
            m1 = n1.next;
        }

        if (n2.next != null) {
            m2 = n2.next;
        }

        Node res = sum(m1, m2);

        int carry = 0;
        if (res.val >= 10) {
            int sum = res.val;
            carry = sum / 10;
            res.val = sum % 10;
        }

        Node h = new Node(n1.val + n2.val + carry);

        h.next = res;

        return h;
    }
}
