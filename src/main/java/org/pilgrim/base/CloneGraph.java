package org.pilgrim.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a Node.
class NodeG {
    public int val;
    public List<NodeG> neighbors;

    public NodeG() {
    }

    public NodeG(int _val, List<NodeG> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

public class CloneGraph {
    private HashMap<NodeG, NodeG> visited = new HashMap<>();

    public NodeG cloneGraph_dfs(NodeG node) {
        if (node == null) {
            return node;
        }

        // If the node was already visited before.
        // Return the clone from the visited dictionary.
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the given node.
        // Note that we don't have cloned neighbors as of now, hence [].
        NodeG cloneNode = new NodeG(node.val, new ArrayList());
        // The key is original node and value being the clone node.
        visited.put(node, cloneNode);

        // Iterate through the neighbors to generate their clones
        // and prepare a list of cloned neighbors to be added to the cloned node.
        for (NodeG neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph_dfs(neighbor));
        }
        return cloneNode;
    }

    public NodeG cloneGraph_bfs(NodeG node) {
        if (node == null) {
            return node;
        }

        // Hash map to save the visited node and it's respective clone
        // as key and value respectively. This helps to avoid cycles.
        HashMap<NodeG, NodeG> visited = new HashMap();

        // Put the first node in the queue
        Queue<NodeG> queue = new LinkedList<NodeG>();
        queue.add(node);
        // Clone the node and put it in the visited dictionary.
        visited.put(node, new NodeG(node.val, new ArrayList()));

        // Start BFS traversal
        while (!queue.isEmpty()) {
            // Pop a node say "n" from the from the front of the queue.
            NodeG n = queue.poll();
            // Iterate through all the neighbors of the node "n"
            for (NodeG neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor and put in the visited, if not present already
                    visited.put(neighbor, new NodeG(neighbor.val, new ArrayList()));
                    // Add the newly encountered node to the queue.
                    queue.add(neighbor);
                }
                // Add the clone of the neighbor to the neighbors of the clone node "n".
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        // Return the clone of the node from visited.
        return visited.get(node);
    }
}