package org.pilgrim.leetcode.y2020.facebook;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
public class Permutations {
    
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length <= 0){
            return null;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }
        
        List<List<Integer>> res = new ArrayList<>();        
        permute(res, list, 0);
        
        return res;
    }
    
    private void permute(List<List<Integer>> res, List<Integer> list, int p){
        if(p == list.size()-1){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=p; i < list.size(); i++){
            swap(list, i, p);
            permute(res, list, p + 1);
            swap(list, i, p);
        }
    }
    
    private void swap(List<Integer> list, int i, int j){
        int t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
