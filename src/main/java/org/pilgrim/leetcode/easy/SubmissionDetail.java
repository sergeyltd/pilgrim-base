package org.pilgrim.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:

The boundaries of each input argument are 1 <= left <= right <= 10000.

 * @author segoncha
 *
 */
public class SubmissionDetail {
	public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        if(left > right){
            return list;
        }
        
        if(left < 10){
            for(int i=left; i<10 && i<right; i++){
                list.add(i);
            }
            left = 11;
        }
        
        while(left <= right){
            //block to get number digets
            int t = left;
            boolean isDiv = true;
            while(t > 0){
                int rem = t%10;
                if(rem == 0){
                    isDiv = false;
                    break;
                }
                if(left % rem != 0){
                    isDiv = false;
                    break;
                }
                t = t/10;    
            }           
            if(isDiv){
                list.add(left);
            }
            left++;
        }
        return list;
    }
}
