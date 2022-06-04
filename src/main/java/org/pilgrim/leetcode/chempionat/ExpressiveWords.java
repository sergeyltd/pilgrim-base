package org.pilgrim.leetcode.chempionat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 809. Expressive Words
User Accepted: 0
User Tried: 1
Total Accepted: 0
Total Submissions: 1
Difficulty: Medium
Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  Here, we have groups, of adjacent letters that are all the same character, and adjacent characters to the group are different.  A group is extended if that group is length 3 or more, so "e" and "o" would be extended in the first example, and "i" would be extended in the second example.  As another example, the groups of "abbcccaaaa" would be "a", "bb", "ccc", and "aaaa"; and "ccc" and "aaaa" are the extended groups of that string.

For some given string S, a query word is stretchy if it can be made to be equal to S by extending some groups.  Formally, we are allowed to repeatedly choose a group (as defined above) of characters c, and add some number of the same character c to it so that the length of the group is 3 or more.  Note that we cannot extend a group of size one like "h" to a group of size two like "hh" - all extensions must leave the group extended - ie., at least 3 characters long.

Given a list of query words, return the number of words that are stretchy. 

Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not extended.
Notes:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters
 * @author segoncha
 *
 */

public class ExpressiveWords {
	
    public int expressiveWords(String S, String[] words) {
    	ArrayList<List<String>> f;
    	new ArrayList<List<String>>();
    	Map<String, String> map = new HashMap<>();
    	
    	for (Map.Entry<String, String> a : map) {
			
		}
    	
    	map.values().stream().lis
    	
    	int res = 0;
    	for (String word : words) {
    		if(S.length() - word.length() < 2){
    			continue;
    		}
    		
    		int i = 0;
    		int j = 0;
    		char last = 0;
    		boolean b = true;
    		boolean tm = false;
    		int num = 1;
			for (; i < S.length() && j < word.length(); i++) {
				char ch1 = S.charAt(i);
				char ch2 = word.charAt(j);
				
				if (ch1 != ch2){
					if(num != 1 && num < 3){
						b = false;
						break;
					}
					ch2 = word.charAt(++j);
					tm = true;
				}
				
				if(ch1==ch2){
					if(!tm && j < word.length() - 1 && ch1 == word.charAt(j+1) && j < i){
						num = 1;
						j++;
					}else if (ch1 == last){
						num++;
					}
					else{
						num = 1;
					}
					tm = false;
					
					last = ch2;
					continue;
				}else{
					b = false;
					break;
				}
			}
			
			if (b){
				res++;
			}
		}
    	
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressiveWords expressiveWords = new ExpressiveWords();
		System.out.println(expressiveWords.expressiveWords("heeellooo", new String[]{"hello"}));
	}

}
