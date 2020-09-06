package org.pilgrim.leetcode.y2020.facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Tmp {

    static Set<Character> openedBrackets = new HashSet<Character>(Arrays.asList('[', '{', '('));
    
    static Map<Character, Character> map;
    static {
        map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    boolean isBalanced(String s) {
        // Write your code here
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> st = new Stack<Character>();
        boolean res = true;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (openedBrackets.contains(ch)) {
                st.push(ch);
            }
            else {
                char br = map.get(st.pop());
                if(br != ch) {
                    res = false;
                }
            }
            

            if (!res) {
                break;
            }
        }

        return res;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        String s_1 = "{[(])}";
        boolean expected_1 = false;
        boolean output_1 = isBalanced(s_1);
        check(expected_1, output_1);

        String s_2 = "{{[[(())]]}}";
        boolean expected_2 = true;
        boolean output_2 = isBalanced(s_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Tmp().run();
    }
}