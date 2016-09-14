package org.pilgrim.base;

public class Brackets
{
    public void permutation(int open,
                            int close,
                            String str)
    {
        if (open == 0 && close == 0)
        {
            System.out.println(str);
        }

        if (open > 0)
        {
            permutation(open - 1, close + 1, str + "(");
        }
        if (close > 0)
        {
            permutation(open, close - 1, str + ")");
        }
    }

    public static void main(String[] args)
    {
        Brackets brackets = new Brackets();
        brackets.permutation(7, 0, "");
    }
}