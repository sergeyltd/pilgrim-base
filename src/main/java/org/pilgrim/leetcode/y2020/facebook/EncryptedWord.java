package org.pilgrim.leetcode.y2020.facebook;

public class EncryptedWord {
    String findEncryptedWord(String s) {
        // Write your code here
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }

        int c = (s.length() - 1) / 2;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(c));
        sb.append(findEncryptedWord(s.substring(0, c)));
        sb.append(findEncryptedWord(s.substring(c + 1)));

        return sb.toString();
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String s_1 = "abc";
        String expected_1 = "bac";
        String output_1 = findEncryptedWord(s_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String expected_2 = "bacd";
        String output_2 = findEncryptedWord(s_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new EncryptedWord().run();
    }
}
