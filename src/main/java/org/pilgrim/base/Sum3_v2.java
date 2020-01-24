package org.pilgrim.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Sum3_v2 {
    
    public static List<List<Integer>> twoSum(int[] nums, int s, int lo, int hi) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i = lo;
        int j = hi;
        while(i<j){
            int b = nums[i];
            int c = nums[j];
            
            if(b > s){
                break;
            }
            
            int hs = b+c;
            
            if(hs == s){
                i++;
                j--;
                List<Integer> item = new ArrayList<>();
                result.add(item);
                item.add(b);
                item.add(c);
                
                // skip same values nearby
                while(i<j && nums[i]==nums[i-1]) i++;
                while(i<j && nums[j]==nums[j+1]) j--;
            }
            else if(hs>s){
                j--;
            }
            else if(hs<s){
                i++;
            }
        }
        
        return result;
    }
    
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 3)
            return result;

        Arrays.sort(nums);
        Set<Integer> uniqueA = new HashSet<>();
        int sum = 0;
        
        for(int k=0; k<nums.length-2; k++){
            int a = nums[k];
            if(uniqueA.contains(a)) {
                continue;
            }
            else {
                uniqueA.add(a);
            }
            
            int s = sum - a;
            List<List<Integer>> listRes = twoSum(nums, s, k+1, nums.length-1);
            if(listRes.size()>0){
                for(List<Integer> item : listRes){
                    item.add(a);
                    Collections.sort(item);
                }
            }
            result.addAll(listRes);
        }        
        
        Iterator<List<Integer>> it = result.iterator();
        List<Integer> node = null;
        if(it.hasNext()) {
            node = it.next();
        }
        while (it.hasNext()) {
            List<Integer> item = it.next();
            if(node.get(0).equals(item.get(0))
               && node.get(1).equals(item.get(1))
               && node.get(2).equals(item.get(2)))
            {
                it.remove();
            }
            else{
                node = item;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {0,0,0};
        List<List<Integer>> res = threeSum(nums);
        
        for(List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
