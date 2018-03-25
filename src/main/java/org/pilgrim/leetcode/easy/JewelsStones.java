package org.pilgrim.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class JewelsStones {
	public int numJewelsInStones(String J, String S) {
        if(null == J || null == S) return 0;
        
        int amount = 0;
        Set<Character> dict = new HashSet<>();
        for(int i=0; i<J.length(); i++){
            dict.add(J.charAt(i));
        }
        
        for(int i=0; i<S.length(); i++){
            if(dict.contains(S.charAt(i))){
                amount++;
            }
        }
        return amount;
    }
}
