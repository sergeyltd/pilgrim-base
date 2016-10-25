package org.pilgrim.base;

public class Crypto
{
    public static void main(String[] args)
    {
        String str = "coo iye xohd wyxnkii dokmrobc";
        char[] charArray = str.toCharArray();
        for (int i = 0; i < 26; i++)
        {
            StringBuilder sb = new StringBuilder();
            for (char ch : charArray)
            {
                if (ch < 'a')
                {
                    sb.append(ch);
                    continue;
                }
                int ch2 = (ch+i - 'a')%26 + 'a';
                sb.append((char)ch2);
            }
            System.out.println(sb);
        }
    }
}
