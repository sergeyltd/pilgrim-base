package org.pilgrim.leetcode.y2020.amazon;

import java.util.List;


/*
 * 
 * 
 * 2. Task of Pairing A company sells dumbbells in pairs. These are weights for exercising. They receive a shipment of dumbbells weighing anywhere from 1 unit up to a certain maximum. A pair can only be sold if their weights are sufficiently close: no greater than 1 unit difference. Given an inventory of various weights, determine the maximum number of pairs the company can sell.     For example, if there are 2 dumbbells of weight 1, 4 of weight 2, 3 of weight 3 and 1 of weight 4, they can be paired as [1,1], [2,2], [2,2], [3,3], [3,4] for a total of 5 pairs.     Function Description  Complete the function taskOfPairing in the editor below. The function must return an integer representing the maximum number of similar pairs that can be made from the given supply of weights.     taskOfPairing has the following parameter(s):      freq[0... n-1]:  a frequency array of integers where the ith element represents the number of dumbbells having a weight of i+1.
 * 
 * 
 */

public class TaskOfParing {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /*
     * Complete the 'taskOfPairing' function below.
     *
     * The function is expected to return a LONG_INTEGER. The function accepts
     * LONG_INTEGER_ARRAY freq as parameter.
     */

    public static long taskOfPairing(List<Long> freq) {
        // Write your code here

        long res = 0l;

        if (freq == null || freq.isEmpty() || freq.size() > 100000) {
            return res;
        }

        long r = 0l;
        for (Long f : freq) {

            if (f > 0 && r > 0) {
                f = f - r;
                res++;
            }

            long d = f / 2;
            res += d;
            r = f % 2;
        }

        return res;
    }

}
