package org.pilgrim.leetcode.y2021;

import java.util.HashMap;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

 

Example 1:

Input: num = 3
Output: "III"
Example 2:

Input: num = 4
Output: "IV"
Example 3:

Input: num = 9
Output: "IX"
Example 4:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= num <= 3999

 * @author sergiy
 *
 */

public class IntegerToRoman {
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap();
        map.put(3000, "MMM");
        map.put(2000, "MM");
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(800, "DCCC");
        map.put(700, "DCC");
        map.put(600, "DC");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(300, "CCC");
        map.put(200, "CC");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(80, "LXXX");
        map.put(70, "LXX");
        map.put(60, "LX");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(30, "XXX");
        map.put(20, "XX");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(8, "VIII");
        map.put(7, "VII");
        map.put(6, "VI");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(3, "III");
        map.put(2, "II");
        map.put(1, "I");
        
        String res = "";
        
        int inc = 1;
        
        while(num != 0){
            int d = num % 10;
            d = d * inc;
            inc *= 10;
            num = num / 10;
            String h = map.get(d);
            if(h != null){
                res = h + res;
            }
        }
        
        return res;
    }
    
    public String intToRoman2(int num) {
        int[] values = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] romans = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder sb = new StringBuilder();

        for(int i = values.length - 1;i>=0 && num>0 ;i--)
        {
            while(num >= values[i])
            {
                num -= values[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }
}