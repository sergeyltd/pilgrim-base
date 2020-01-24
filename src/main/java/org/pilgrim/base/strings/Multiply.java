package org.pilgrim.base.strings;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Multiply {

    public String multiply_my(String num1, String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        return a.multiply(b).toString();
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        else if (num1.equals("") || num2.equals("")) {
            String ans = "";
            for (int i = 0; i < Math.max(num1.length(), num2.length()) - 1; i++)
                ans += "0";
            return ans;
        }
        List<Integer> list = new ArrayList<Integer>();
        int carry = 0;
        for (int i = num2.length() - 1, pos = 0; i >= 0; i--, pos = num2.length() - 1 - i) {
            for (int j = num1.length() - 1; j >= 0; j--, pos++) {
                int n2 = num2.charAt(i) - '0';
                int n1 = num1.charAt(j) - '0';
                int m = n1 * n2 + carry;
                int d = m % 10;
                carry = m / 10;
                if (list.size() > pos) {
                    int sum = d + list.get(pos);
                    d = sum % 10;
                    carry += sum / 10;
                    list.set(pos, d);
                } else
                    list.add(d);
            }
            if (carry > 0)
                list.add(carry);
            carry = 0;
        }
        if (carry > 0)
            list.add(carry);
        String ans = "";
        for (int i = 0; i < list.size(); i++)
            ans = list.get(i) + ans;
        return ans;
    }

    public static void main(String[] args) {
    }
}
