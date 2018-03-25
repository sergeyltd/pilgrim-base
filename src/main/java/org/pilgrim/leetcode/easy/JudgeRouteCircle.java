package org.pilgrim.leetcode.easy;

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true

Example 2:
Input: "LL"
Output: false

 * @author segoncha
 *
 */
public class JudgeRouteCircle {
	public boolean judgeCircle(String moves) {
        if(null == moves) return false;
        int[] a = new int['U'+1];
        for(int i=0; i<moves.length();i++){
            char ch = moves.charAt(i);
            a[ch]++;
        }
        return (a['L']-a['R'])==0 && (a['U']-a['D'])==0;
    }
	
	public boolean judgeCircle2(String moves) {
        if(null == moves) return false;
        int left = 0;
        int up = 0;
        for(int i=0; i<moves.length();i++){
            char ch = moves.charAt(i);
            switch (ch)
            {
                case 'U':
                    up++;
                    break;
                case 'D':
                    up--;
                    break;
                case 'L':
                    left++;
                    break;
                case 'R':
                    left--;
                    break;
            }
        }
        return left==0 && up==0;
    }
}
