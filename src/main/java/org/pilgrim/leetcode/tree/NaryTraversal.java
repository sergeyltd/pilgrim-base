package org.pilgrim.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NaryTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            res.add(node.val);
            
            for(int i=node.children.size()-1; i>=0; i--){
                Node chNode = node.children.get(i);
                if(chNode != null){
                    stack.push(chNode);
                }
            }
        }
        
        return res;
    }
}