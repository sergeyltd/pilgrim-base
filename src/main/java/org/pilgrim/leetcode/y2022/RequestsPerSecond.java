package org.pilgrim.leetcode.y2022;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Arrays;

public class RequestsPerSecond {
	
	final int[] buckets = new int[50]; // 1 hour
	final int window = 5; // 1 minute

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		RequestsPerSecond requestsPerSecond = new RequestsPerSecond();
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					requestsPerSecond.purge();
					

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		thread.start();

		
		
		while(true) {
			requestsPerSecond.countRequest();
			System.out.println("Request per second for last 10 sec: " + requestsPerSecond.getRequestPerSec());
			System.out.println(Arrays.toString(requestsPerSecond.buckets));
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void countRequest() {
		int buckId = getBucketId();
		
		buckets[buckId]++;
	}
	
	public int getRequestPerSec() {
		int buckId = getBucketId();
		
		double avg = 0;
		for(int i=0; i<window; i++) {
			int j = (buckId - i + buckets.length) % buckets.length;
			avg += buckets[j];
		}
		
		return (int)(avg / window);
	}
	
	private void purge() {
		int buckId0 = getBucketId();
		int buckIdn = (buckId0 - window - 10  + buckets.length) % buckets.length;
		
		int start = buckIdn < buckId0 ? 0 : buckId0;
		
		for(int i = start; i<buckIdn; i++) {
			buckets[i] = 0;
		}
		
		int end = buckIdn < buckId0 ? buckets.length : buckIdn;
		
		for(int i = buckId0; i<end; i++) {
			buckets[i] = 0;
		}		
	}
	
	private int getBucketId() {
		ZonedDateTime now = ZonedDateTime.now();
		int sec = now.getMinute() * 60 + now.getSecond();
		
		return sec % buckets.length;	
		
//		return 10;
	}

}
