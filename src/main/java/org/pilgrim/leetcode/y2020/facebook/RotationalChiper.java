package org.pilgrim.leetcode.y2020.facebook;

public class RotationalChiper {
    // Add any extra import statements you may need here

    // Add any helper functions you may need here

    char rotateChar(char ch, int r) {

        if (isNumeric(ch)) {
            return rotate(ch, r, '0', '9');
        }

        if (isAlphabeticLowCase(ch)) {
            return rotate(ch, r, 'a', 'z');
        }

        if (isAlphabeticUpperCase(ch)) {
            return rotate(ch, r, 'A', 'Z');
        }

        return ch;
    }

    private boolean isNumeric(char ch) {
        return ch - '0' >= 0 && '9' - ch >= 0;
    }

    private boolean isAlphabeticUpperCase(char ch) {
        return ch - 'A' >= 0 && 'Z' - ch >= 0;
    }

    private boolean isAlphabeticLowCase(char ch) {
        return ch - 'a' >= 0 && 'z' - ch >= 0;
    }

    private char rotate(char ch, int r, char lo, char hi) {
        int n = hi - lo + 1;
        int i = ch - lo;
        int j = (i+r)%n;
        return (char) (j+lo);
    }

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here

        if (input == null || input.isEmpty() || rotationFactor < 1) {
            return input;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = rotateChar(input.charAt(i), rotationFactor);
            sb.append(ch);
        }

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
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new RotationalChiper().run();
    }
}
