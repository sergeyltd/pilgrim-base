package org.pilgrim.leetcode.y2022;

public class CalculateAmountPaidTaxes {

	public static void main(String[] args) {
		System.out.println(calculateTax(new int[][] {{3,50}, {7,10}, {12,25}}, 10));
		System.out.println(calculateTax(new int[][] {{1,0}, {4,25}, {5,50}}, 2));
		System.out.println(calculateTax(new int[][] {{2,50}}, 0));

	}
	
	public static double calculateTax(int[][] brackets, int income) {
        // Validate input
        if(brackets == null || brackets.length <=0 || brackets[0].length != 2 || income <= 0 || income > 1000){
            return 0d;
        }
        
        int[][] b = brackets;
        int a = income;
        double res = 0d;
        double d = 0;
        for(int i=0; i<b.length; i++){
            if(a <= 0){
                break;
            }          
            
            if(i > 0) {
            	d = b[i][0] - b[i-1][0];
            }
            else {
            	d = b[i][0];
            }
            
            if(a < d){
                d = a;
            }
            
            res += d * b[i][1] / 100d;
            a -= d;
        }
        
        return res;
    }
}
