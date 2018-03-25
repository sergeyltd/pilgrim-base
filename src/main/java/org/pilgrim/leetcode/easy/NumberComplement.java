package org.pilgrim.leetcode.easy;
/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

 * @author segoncha
 *
 */

public class NumberComplement {

	public static int findComplement(int num) {
        int log2FromNum = 0;
        int t = num;
        while(t > 1){
            t = t/2;
            log2FromNum++;
        }
        
        int mask = (int) (Math.pow(2, log2FromNum+1)-1);
        return num^mask;
    }
	
	public static void main(String[] args) {
		System.out.println(findComplement(1));
	}
}
