package org.pilgrim.base.google;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {

    public static int totalFruit(int[] tree) {
        int ans = 0, i = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < tree.length; ++j) {
            Integer c = count.get(tree[j]);
            count.put(tree[j], null == c ? 1 : c + 1);
            while (count.size() >= 3) {
                count.put(tree[i], count.get(tree[i]) - 1);
                if (count.get(tree[i]) == 0)
                    count.remove(tree[i]);
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] tree = {3,3,3,1,2,1,1,2,3,2,2,2,2,3,2,4};
        System.out.println(totalFruit(tree));
    }
}
