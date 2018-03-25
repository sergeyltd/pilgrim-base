package org.pilgrim.leetcode.easy;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".
 

Note:

The length of words will be at most 100.
Each words[i] will have length in range [1, 12].
words[i] will only consist of lowercase letters.
 */

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {

	String[] dict = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
			"---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

	public int uniqueMorseRepresentations(String[] words) {
		if (null == words || words.length <= 0) {
			return 0;
		}
		Set<String> list = new HashSet<>();
		for (String word : words) {
			if (null != word) {
				list.add(convert(word.toLowerCase()));
			}
		}

		return list.size();
	}

	private String convert(String word) {
		StringBuilder sb = new StringBuilder(1000);
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			sb.append(dict[index]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueMorseCodeWords codeWords = new UniqueMorseCodeWords();

		{
			String[] words = { "gin", "zen", "gig", "msg" };
			System.out.println(codeWords.uniqueMorseRepresentations(words));
		}
		
		{
			String[] words = { "sd" };
			System.out.println(codeWords.uniqueMorseRepresentations(words));
		}
	}

}
