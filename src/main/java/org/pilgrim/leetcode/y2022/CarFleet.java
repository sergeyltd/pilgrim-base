package org.pilgrim.leetcode.y2022;

import java.util.Arrays;

/**
 *
 * There are n cars going to the same destination along a one-lane road. The
 * destination is target miles away. You are given two integer array position
 * and speed, both of length n, where position[i] is the position of the ith car
 * and speed[i] is the speed of the ith car (in miles per hour). A car can never
 * pass another car ahead of it, but it can catch up to it and drive bumper to
 * bumper at the same speed. The faster car will slow down to match the slower
 * car's speed. The distance between these two cars is ignored (i.e., they are
 * assumed to have the same position). A car fleet is some non-empty set of cars
 * driving at the same position and same speed. Note that a single car is also a
 * car fleet. If a car catches up to a car fleet right at the destination point,
 * it will still be considered as one car fleet. Return the number of car fleets
 * that will arrive at the destination.
 *
 */
public class CarFleet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public int carFleet(int target, int[] position, int[] speed) {
		int fleet = 0;

		// Positions to time to destination
		double[][] cars = new double[position.length][2];

		for (int i = 0; i < position.length; i++) {
			double time_to_dest = (double) (target - position[i]) / speed[i];
			cars[i] = new double[] { position[i], time_to_dest };
		}

		// Sort by position ascending order
		Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

		double current_time = 0;
		for (int i = cars.length - 1; i >= 0; i--) {
			
			// Count intersections by time and count them as fleet
			if (cars[i][1] > current_time) {
				fleet++;
				current_time = cars[i][1];
			}
		}

		return fleet;
	}
}
