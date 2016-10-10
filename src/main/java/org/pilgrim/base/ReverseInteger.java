package org.pilgrim.base;

public class ReverseInteger {
	public int reverse(int x) {
		//flag marks if x is negative
		boolean flag = false;
		if (x < 0) {
			x = 0 - x;
			flag = true;
		}
	 
		int res = 0;
		int p = x;
	 
		while (p > 0) {
			int mod = p % 10;
			p = p / 10;
			res = res * 10 + mod;
		}
	 
		if (flag) {
			res = 0 - res;
		}
	 
		return res;
	}
	
	public int reverse2(int x) {
	    int rev = 0;
	    while(x != 0){
	        rev = rev*10 + x%10;
	        x = x/10;
	    }
	 
	    return rev;
	}
}
