package org.pilgrim.leetcode.y2022;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestsPerSecond {

	final int[] buckets = new int[1000]; // 1 hour
	final int window = 5; // 1 minute

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		RequestsPerSecond requestsPerSecond = new RequestsPerSecond();

		Thread threadPurge = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					requestsPerSecond.purge();

					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		threadPurge.start();

		Thread threadSendRequest = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					requestsPerSecond.countRequest();

					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		threadSendRequest.start();

		while (true) {
			List<Integer> list = new ArrayList<>(100);
			for(int b : requestsPerSecond.buckets) {
				if(b != 0) {
					list.add(b);
				}
			}
			
			System.out.println(Arrays.toString(list.toArray()));
			System.out.println("Request per second for last 10 sec: " + requestsPerSecond.getRequestPerSec());
			
			System.in.read();
		}
	}

	public void countRequest() {
		int buckId = getBucketId();

		buckets[buckId]++;
	}

	public int getRequestPerSec() {
		int buckId = getBucketId();

		double avg = 0;
		for (int i = 0; i < window; i++) {
			int j = (buckId - i + buckets.length) % buckets.length;
			avg += buckets[j];
		}

		return (int) (avg / window);
	}

	private void purge() {
		int buckId0 = getBucketId();
		int buckIdn = (buckId0 - window - 10 + buckets.length) % buckets.length;

		int start = buckIdn < buckId0 ? 0 : buckId0;

		for (int i = start; i < buckIdn; i++) {
			buckets[i] = 0;
		}

		int end = buckIdn < buckId0 ? buckets.length : buckIdn;

		for (int i = buckId0; i < end; i++) {
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
