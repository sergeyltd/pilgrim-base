35. Search Insert Position 
 
https://leetcode.com/articles/search-insert-position/

 
 

Average Rating: 4.76 (21 votes)

March 1, 2020  |  15.7K views
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
Solution
Approach 1: Binary Search
Intuition

Based on the description of the problem, we can see that it could be a good match with the binary search algorithm.

Binary search is a search algorithm that find the position of a target value within a sorted array.

Usually, within binary search, we compare the target value to the middle element of the array at each iteration.

If the target value is equal to the middle element, the job is done.

If the target value is less than the middle element, continue to search on the left.

If the target value is greater than the middle element, continue to search on the right.

Here we showcase a simple example on how it works.

simple
To mark the search boundaries, one could use two pointers: left and right. Starting from left = 0 and right = n - 1, we then move either of the pointers according to various situations:

While left <= right:

Pivot index is the one in the middle: pivot = (left + right) / 2. The pivot also divides the original array into two subarray.

If the target value is equal to the pivot element: target == nums[pivot], we're done.

If the target value is less than the pivot element target < nums[pivot], continue to search on the left subarray by moving the right pointer right = pivot - 1.

If the target value is greater than the pivot element target > nums[pivot], continue to search on the right subarray by moving the left pointer left = pivot + 1.

two

What if the target value is not found?

In this case, the loop will be stopped at the moment when right < left and nums[right] < target < nums[left]. Hence, the proper position to insert the target is at the index left.

two

Integer Overflow

Let us now stress the fact that pivot = (left + right) // 2 works fine for Python3, which has arbitrary precision integers, but it could cause some issues in Java and C++.

If left + right is greater than the maximum int value 2^{31} - 12 
31
 −1, it overflows to a negative value. In Java, it would trigger an exception of ArrayIndexOutOfBoundsException, and in C++ it causes an illegal write, which leads to memory corruption and unpredictable results.

Here is a simple way to fix it:


and here is a bit more complicated but probably faster way using the bit shift operator.


Algorithm

Initialize the left and right pointers : left = 0, right = n - 1.

While left <= right:

Compare middle element of the array nums[pivot] to the target value target.

If the middle element is the target, i.e. target == nums[pivot]: return pivot.

If the target is not here:

If target < nums[pivot], continue to search on the left subarray. right = pivot - 1.

Else continue to search on the right subarray. left = pivot + 1.

Return left.

Implementation

Current
1 / 5

Complexity Analysis

Time complexity : \mathcal{O}(\log N)O(logN).

Let us compute the time complexity with the help of master theorem T(N) = aT\left(\frac{N}{b}\right) + \Theta(N^d)T(N)=aT( 
b
N
​	
 )+Θ(N 
d
 ). The equation represents dividing the problem up into aa subproblems of size \frac{N}{b} 
b
N
​	
  in \Theta(N^d)Θ(N 
d
 ) time. Here at each step there is only one subproblem i.e. a = 1, its size is a half of the initial problem i.e. b = 2, and all this happens in a constant time i.e. d = 0. As a result, \log_b{a} = dlog 
b
​	
 a=d and hence we're dealing with case 2 that results in \mathcal{O}(n^{\log_b{a}} \log^{d + 1} N)O(n 
log 
b
​	
 a
 log 
d+1
 N) = \mathcal{O}(\log N)O(logN) time complexity.

Space complexity : \mathcal{O}(1)O(1) since it's a constant space solution.