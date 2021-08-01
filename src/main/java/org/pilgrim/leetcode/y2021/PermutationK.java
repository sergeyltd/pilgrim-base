package org.pilgrim.leetcode.y2021;

import java.util.ArrayList;

public class PermutationK {
    String strK = null;
    int c = 0;
    public String getPermutation(int n, int k) {
        if(n < 1 || n > 9 || k < 1 || k > fact(n)){
            return null;
        }
        
        String s = "";
        for(int i=1; i<=n; i++){
            s += i;
        }
        
        permutation(s, "", k);
        
        return strK;
    }
    
    public String getPermutation2(int n, int k) {
        int fact = 1;
        ArrayList<Integer> nums = new ArrayList<>();

        for(int i = 1;i<n;i++) {
            fact = fact * i;
            nums.add(i);
        }
        nums.add(n);
        k--;
        String ans = "";

        while(true) {
            ans = ans + nums.get(k / fact);
            nums.remove(k / fact);
            if(nums.size() == 0) {
                break;
            }
            k = k % fact;   
            fact = fact / nums.size();
        }
        return ans;
    }
    
    private void permutation(String s, String res, int k) {
        if(s.length() == 0){
            c++;
            
            if(k == c){
                strK = res;
            }
            else{
                return;
            }
        }
        
        if(strK != null){
            return;
        }
        
        for(int i=0; i<s.length(); i++){
            permutation(s.substring(0,i) + s.substring(i+1), res + s.charAt(i), k);
        }
    }
    
    private int fact(int k){
        int res = 1;
        
        for(int i=2; i<=k; i++){
            res *= i;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        PermutationK sol = new PermutationK();
        System.out.println(sol.getPermutation(9, 76546));
        System.out.println(sol.getPermutation2(3, 4));
    }
}