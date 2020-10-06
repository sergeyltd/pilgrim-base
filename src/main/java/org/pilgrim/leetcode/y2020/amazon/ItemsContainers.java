package org.pilgrim.leetcode.y2020.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class ItemsContainers {

    /*
     * 
     * Items in Containers
     * 
     * Amazon would like to know how much inventory exists in their closed inventory
     * compartments. Given a string s consisting of items as "*" and closed
     * compartments as an open and close "|", an array of starting indices
     * startIndices, and an array of ending indices endIndices, determine the number
     * of items in closed compartments within the substring between the two indices,
     * inclusive.
     * 
     * An item is represented as an asterisk ('*' = ascii decimal 42) A compartment
     * is represented as a pair of pipes that may or may not have items between them
     * ('|' = ascii decimal 124).
     * 
     * Example
     * 
     * s = '|**|*|*'
     * 
     * startIndices = [1, 1]
     * 
     * endIndices = [5, 6]
     * 
     * The string has a total of 2 closed compartments, one with 2 items and one
     * with 1 item. For the first pair of indices, (1, 5), the substring is '|**|*'.
     * There are 2 items in a compartment.
     * 
     * For the second pair of indices, (1, 6), the substring is '|**|*|' and there
     * are 2 + 1 = 3 items in compartments.
     * 
     * Both of the answers are returned in an array, [2, 3].
     * 
     * Function Description .
     * 
     * Complete the numberOfItems function in the editor below. The function must
     * return an integer array that contains the results for each of the
     * startIndices[i] and endIndices[i] pairs.
     * 
     * numberOfItems has three parameters:
     * 
     * s: A string to evaluate
     * 
     * startIndices: An integer array, the starting indices.
     * 
     * endIndices: An integer array, the ending indices.
     * 
     * Constraints
     * 
     * 1 ≤ m, n ≤ 105 1 ≤ startIndices[i] ≤ endIndices[i] ≤ n Each character of s is
     * either '*' or '|'
     * 
     * Input Format For Custom Testing
     * 
     * The first line contains a string, S. The next line contains an integer, n,
     * the number of elements in startIndices. Each line i of the n subsequent lines
     * (where 1 ≤ i ≤ n) contains an integer, startIndices[i]. The next line repeats
     * the integer, n, the number of elements in endIndices. Each line i of the n
     * subsequent lines (where 1 ≤ i ≤ n) contains an integer, endIndices[i].
     * 
     * Sample Case 0 Sample Input For Custom Testing
     * 
     * STDIN Function
     * 
     * |*| -> s = "*|*|"
     * 
     * 1 -> startIndices[] size n = 1 1 -> startIndices = 1 1 -> endIndices[] size n
     * = 1 3 -> endIndices = 3
     ** 
     * Sample Output** 0
     * 
     * Explanation s = *|*|
     * 
     * n = 1 startIndices = [1] n = 1 startIndices = [3]
     * 
     * The substring from index = 1 to index = 3 is '|'. There is no compartments in
     * this string.
     * 
     * Sample Case 1 Sample Input For Custom Testing
     * 
     * STDIN Function
     * 
     * |*|*| -> s = "*|*|*|" 1 -> startIndices[] size n = 1 1 -> startIndices = 1 1
     * -> endIndices[] size n = 1 6 -> endIndices = 6
     * 
     * Sample Output 2
     * 
     * Explanation s = '*|*|*|' n = 1 startIndices = [1] n = 1 startIndices = [1]
     * 
     * The substring from index = 1 to index = 6 is '||*|'. There are two
     * compartments in this string at (index = 2, index = 4) and (index = 4, index =
     * 6). There are 2 items between these compartments.
     * 
     * 
     */

    /*
     * Complete the 'numberOfItems' function below.
     *
     * The function is expected to return an INTEGER_ARRAY. The function accepts
     * following parameters: 1. STRING s 2. INTEGER_ARRAY startIndices 3.
     * INTEGER_ARRAY endIndices
     */

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {

        List<Integer> res = new ArrayList<>();
        if (s == null || s.isEmpty() || startIndices == null || startIndices.isEmpty() || endIndices == null
                || endIndices.isEmpty()) {
            return res;
        }

        NavigableMap<Integer, Integer> map = new TreeMap<>();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (ch == '|') {
                map.put(i, count);
            } else if (ch == '*') {
                count++;
            } else {
                return res;
            }
        }

        for (int i = 0; i < startIndices.size(); i++) {
            res.add(calculate(map, startIndices.get(i) - 1, endIndices.get(i) - 1));
        }

        return res;
    }

    private static int calculate(NavigableMap<Integer, Integer> map, int start, int end) {
        int val = map.floorEntry(end).getValue() - map.ceilingEntry(start).getValue();

        return Math.max(0, val);
    }
}
