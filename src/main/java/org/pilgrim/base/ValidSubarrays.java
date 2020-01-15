package org.pilgrim.base;

import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class ValidSubarrays {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if(root == null)
        {
            return list;
        }
        
        for(Node node : root.children){
            list.addAll(postorder(node));
        }
        list.add(root);
        
        return list;
    }
    public static int validSubarrays(int[] nums) {

        int r = 0;
        int s = 1;

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if (a <= b) {
                    s++;
                } else {
                    break;
                }
            }
            r += s;
            s = 1;
        }

        return r;
    }

    public static void main(String[] args) {
        int[] ar = new int[] { 1, 4, 2, 5, 3 };
        System.out.println(validSubarrays(ar));
    }
}