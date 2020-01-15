/*
 * Approach #1: Breadth-First Search [Accepted]
Intuition

We can think of this problem as a shortest path problem on a graph: there are 10000 nodes (strings '0000' to '9999'), and there is an edge between two nodes if they differ in one digit, that digit differs by 1 (wrapping around, so '0' and '9' differ by 1), and if both nodes are not in deadends.

Algorithm

To solve a shortest path problem, we use a breadth-first search. The basic structure uses a Queue queue plus a Set seen that records if a node has ever been enqueued. This pushes all the work to the neighbors function - in our Python implementation, all the code after while queue: is template code, except for if node in dead: continue.

As for the neighbors function, for each position in the lock i = 0, 1, 2, 3, for each of the turns d = -1, 1, we determine the value of the lock after the i-th wheel has been turned in the direction d.

Care should be taken in our algorithm, as the graph does not have an edge unless both nodes are not in deadends. If our neighbors function checks only the target for being in deadends, we also need to check whether '0000' is in deadends at the beginning. In our implementation, we check at the visitor level so as to neatly handle this problem in all cases.

In Java, our implementation also inlines the neighbors function for convenience, and uses null inputs in the queue to represent a layer change. When the layer changes, we depth++ our global counter, and queue.peek() != null checks if there are still nodes enqueued.


Complexity Analysis

Time Complexity: O(N^2 * \mathcal{A}^N + D)O(N 
2
 ∗A 
N
 +D) where \mathcal{A}A is the number of digits in our alphabet, NN is the number of digits in the lock, and DD is the size of deadends. We might visit every lock combination, plus we need to instantiate our set dead. When we visit every lock combination, we spend O(N^2)O(N 
2
 ) time enumerating through and constructing each node.

Space Complexity: O(\mathcal{A}^N + D)O(A 
N
 +D), for the queue and the set dead.
 */
package org.pilgrim.base;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
    /**
     * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * Output: 6 Explanation: A sequence of valid moves would be "0000" -> "1000" ->
     * "1100" -> "1200" -> "1201" -> "1202" -> "0202". Note that a sequence like
     * "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid, because the
     * wheels of the lock become stuck after the display becomes the dead end
     * "0102".
     * 
     * @param args
     */
    public static void main(String[] args) {
        OpenTheLock locker = new OpenTheLock();
        int res = locker.openLock(new String[] { "0201", "0101", "0102", "1212", "2002" }, "0202");

        System.out.println(res);
    }

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet();
        for (String d : deadends)
            dead.add(d);

        Queue<String> queue = new LinkedList();
        queue.offer("0000");

        Set<String> seen = new HashSet();
        seen.add("0000");

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String node = queue.poll();
                if (node.equals(target)) {
                    return depth;
                } else if (!dead.contains(node)) {
                    for (int i = 0; i < 4; ++i) {
                        for (int d = -1; d <= 1; d += 2) {
                            int y = ((node.charAt(i) - '0') + d + 10) % 10;
                            String nei = node.substring(0, i) + ("" + y) + node.substring(i + 1);
                            if (!seen.contains(nei)) {
                                seen.add(nei);
                                queue.offer(nei);
                            }
                        }
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}
