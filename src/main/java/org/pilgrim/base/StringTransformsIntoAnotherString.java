package org.pilgrim.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringTransformsIntoAnotherString {

    public static void main(String[] args) {
//        String str1 = "aabcc", str2 = "ccdee";
//        String str1 = "leetcode", str2 = "codeleet";
//        "abcdefghijklmnopqrstuvwxyz"
//        "bcdefghijklmnopqrstuvwxyzq"
        String str1 = "abcdefghijklmnopqrstuvwxyz";
        String str2 = "bcdefghijklmnopqrstuvwxyzq";
        
        StringTransformsIntoAnotherString stclass = new StringTransformsIntoAnotherString();
        System.out.println(stclass.canConvert(str1, str2));
    }
    
    public boolean canConvert(String str1, String str2) {
        if(null == str1 || null == str2 || Integer.compare(str1.length(), str2.length()) != 0){
            return false;
        }

        if(str1.equals(str2)){
            return true;
        }
        
        if((str1.length()!=2 && (str1+str1).contains(str2))){
            return false;
        }
                
        Map<Character, Set<Integer>> m1 = toMap(str1);
        Map<Character, Set<Integer>> m2 = toMap(str2);
        
        boolean res = true;
        for (int i=0; i<str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            Set<Integer> indexes1 = m1.get(ch1);
            Set<Integer> indexes2 = m2.get(ch2);
            
            res &= compareSet(indexes1, indexes2);
        }
        
        return res;
    }
    
    private boolean compareSet(Set<Integer> indexes1, Set<Integer> indexes2) {
        if(indexes1 == null || indexes2 == null/* || indexes1.size() != indexes2.size()*/)
        {
            return false;
        }
        
        boolean res = true;
        for (Integer i : indexes1) {
            if(!indexes2.contains(i)) {
                res = false;
                break;
            }
        }
        
        return res;
    }

    private Map<Character, Set<Integer>> toMap(String str){
        Map<Character, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            Character ch = str.charAt(i);
            Set<Integer> indexes = map.get(ch);
            if(null == indexes){
                indexes = new HashSet<Integer>();
            }
            indexes.add(i);
            map.put(ch, indexes);
        }
        
        return map;
    }

}
