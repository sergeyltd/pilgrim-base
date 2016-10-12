package org.pilgrim.base;

public class Sqrt {
	static public double sqrt2(double n, double ac) {
		double r = 1;
		double t = 0;
		while (Math.abs(r - t) > ac) {
			t = r;
			r = (r + n / r) / 2d;
		}
		return r;
	}

	public static void main(String[] args) {
		double n = 2;
		double ac = 0.0001;//getMashineNull();
		System.out.println(ac);
		System.out.println(sqrt(n, ac));
		System.out.println(sqrt2(n, ac));
		System.out.println(Math.sqrt(n));
	}

	private static double getMashineNull() {
		float r = 1/2f;
		float t = 0;
		float k=0;
		while(Math.abs(r)!=Math.abs(t))
		{
			k = t;
			t = r;
			r=r/2f;
		}
		return k;
	}

	private static double sqrt(double n, double ac) {
		double r = n;
		double st = 1;
		double en = n;
		double m2 = 0;
		while (Math.abs(m2-n) > ac) {
			double m = (en+st)/2d;
			r = m;
			m2 = m*m;
			if (m2 > n)
			{
				en = m;
			}
			else if (m2 < n)
			{
				st = m;
			}
			else
			{
				return r;
			}
		}
		return r;
	}
}
