package org.pilgrim.leetcode.y2022;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/***
 * 
 * Description
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Please implement encode and decode

Example
Example1

Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]
Explanation:
One possible encode method is: "lint:;code:;love:;you"
Example2

Input: ["we", "say", ":", "yes"]
Output: ["we", "say", ":", "yes"]
Explanation:
One possible encode method is: "we:;say:;:::;yes"
 * 
 * @author sergiy
 *
 */

public class EncodeDecodeString {
	public class Solution {
	    /**
	     * @param strs a list of strings
	     * @return encodes a list of strings to a single string.
	     */
	    public String encode(List<String> strs) {
	        // Write your code here
	        StringBuilder ans = new StringBuilder();
	        for (String s : strs) {
	            for (char c : s.toCharArray()) {
	                if (c == ':') {                  // : itself
	                    ans.append("::");
	                } else {                         //ordinary character
	                    ans.append(c);
	                }
	            }
	            ans.append(":;");                    // ; connector
	        }
	        return ans.toString();
	    }

	    /**
	     * @param str a string
	     * @return dcodes a single string to a list of strings
	     */
	    public List<String> decode(String str) {
	    	
	    	PriorityQueue<Pair<Integer, Integer>> mh = new PriorityQueue<>(Pair::getKey);
	    	
	    	String.class.getTypeName()
	    	
	        // Write your code here
	        List<String> ans = new ArrayList<>();
	        char[] sc = str.toCharArray();
	        StringBuilder item = new StringBuilder();
	        int i = 0;
	        while (i < str.length()) {
	            if (sc[i] == ':') {                  //escape
	                if (sc[i + 1] == ';') {          // ; connector
	                    ans.add(item.toString());
	                    item = new StringBuilder();
	                    i += 2;
	                } else {                         // : itself
	                    item.append(sc[i + 1]);
	                    i += 2;
	                }
	            } else {                             //ordinary character
	                item.append(sc[i]);
	                i += 1;
	            }
	        }
	        return ans;
	    }
	}
}
