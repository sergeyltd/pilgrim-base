package org.pilgrim.leetcode.y2022;

/***
 * 
 * 125. Valid Palindrome
Easy

3807

5307

Add to List

Share
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 * 
 */

public class PalindromSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
	
	public static boolean isPalindrome(String s) {
        // Validate input parameters
        if(s==null || s.length() <= 0){
            return false;
        }
        
        int n = s.length();
        s = s.toLowerCase();
        
        // Traverse and compare from beginning to end
        for(int i=0, j=n-1; i<n && j>i; i++, j--){
            char stch = s.charAt(i);
            while(!isAlphanumeric(stch) && i < j){
                stch = s.charAt(++i);
            }
            
            char ench = s.charAt(j);
            while(!isAlphanumeric(ench) && j > i ){
                ench = s.charAt(--j);
            }
            
            if(stch != ench){
                return false;
            }
        }
        
        return true;
    }
    
    private static boolean isAlphanumeric(char ch){
        return ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'));
    }

}
