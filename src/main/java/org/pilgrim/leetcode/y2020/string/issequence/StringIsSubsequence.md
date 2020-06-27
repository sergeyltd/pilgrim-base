392. Is Subsequence 
 
https://leetcode.com/articles/is-subsequence/
 
 

Average Rating: 4.74 (34 votes)

May 19, 2020  |  14.4K views
Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 10^4
Both strings consists only of lowercase characters.
Solution
Overview
First of all, one might be deceived by the Easy tag of the problem. The solution might be simple (i.e. judging by the number of code lines), yet the problem itself is much more intriguing, especially when one is asked to prove the correctness of the solution, not to mention that we have an interesting and legitimate follow-up question.

Also, one might be puzzled with the hints from the problem description, which says "Binary Search", "Dynamic Programing" and "Greedy". There is no doubt that each of them does characterize some trait of the solutions, although the order of these keywords might be misleading. Arguably, the keyword Greedy is more important than the other two.

One will see in the following sections, how each of the above techniques plays out in the solutions. We will also cover the follow-up question in one of the solutions.



Approach 1: Divide and Conquer with Greedy
Intuition

The problem concerns the string matching issues, for which often one can apply a technique called divide and conquer.

The general idea of the divide and conquer technique is to reduce the problem down into subproblems with smaller scales recursively until the problem becomes small enough to tackle with. We then use the results of subproblems to construct the solution for the original problem.

For more details, one can refer to the chapter of divide and conquer in our Explore card.

Here we show how to break down our problem step by step. Given two strings \text{source}source and \text{target}target, we are asked to determine if the \text{source}source string is a subsequence of the \text{target}target string, i.e. \text{isSubsequence(source, target)}isSubsequence(source, target)

Let us start from the first characters of each string, i.e. \text{source[0]}source[0], \text{target[0]}target[0]. By comparing them, there could be two cases as follows:

Case 1): they are identical, i.e. \text{source[0]} = \text{target[0]}source[0]=target[0]

In this case, the best strategy would be to cross out the first characters in both strings, and then continue with the matching job.

match

By the above action, we reduce the input into a smaller scale. It boils down to determine if the rest source string (i.e. \text{source[1:]}source[1:]) is a subsequence of the rest of target string (i.e. \text{target[1:]}target[1:]), which we could summarize in the following recursive formula:

\text{isSubsequence(source, target)} = \text{isSubsequence(source[1:], target[1:])}
isSubsequence(source, target)=isSubsequence(source[1:], target[1:])

Case 2): they are not identical, i.e. \text{source[0]} \neq \text{target[0]}source[0] 

​	
 =target[0]

non-match

In this case, the only thing we can do is to skip (cross out) the first character in the target string, and keep on searching in the target string in the hope that we would find a letter that could match the first character in the source string.

Now, it boils down to determine if the source string could be a subsequence for the rest of the target string, which we summarize as follows:

\text{isSubsequence(source, target)} = \text{isSubsequence(source, target[1:])}
isSubsequence(source, target)=isSubsequence(source, target[1:])

Let us combine the above two cases as follows, which consists of our baby steps of divide and conquer, by looking at the first characters of each string.

\text{isSubsequence(source, target)} = \left\{ \begin{array}{l} \text{isSubsequence(source[1:], target[1:])} \\ \text{isSubsequence(source, target[1:])} \end{array} \right.
isSubsequence(source, target)={ 
isSubsequence(source[1:], target[1:])
isSubsequence(source, target[1:])
​	
 

It should be intuitive to implement a recursive solution with the above formulas.

To make the recursion complete, we should also define the base cases properly. In this problem, we have two particular base cases:

The \text{source}source becomes empty, i.e. we found matches for all the letters in the source string. Hence, the source string is a subsequence of the target string.

The \text{target}target becomes empty, i.e. we exhaust the target string, yet there are still some letters left unmatched in the source string. Hence, the source string is not a subsequence of the target string.

Greedy

Before jumping into the implementation, we would like to discuss an important strategy that we adopted here, other than the divide and conquer technique.

That is right. It is the Greedy strategy, which we did not mention in the intuition section.

As one might recall, when the first characters of the source and target strings match, we mentioned that the best strategy is to cross out the matched characters from both strings and then continue with the matching.

The other possible action could be that we dismiss this match and continue the search in the target string.

dismiss match

By adopting the best strategy, we were greedily crossing out the matched character from the source string, rather than deferring the match.

One might question if the result is correct with the greedy strategy, since it does seem that we were missing out some other alternatives.

To prove the correctness of greedy algorithms, often we apply the contradiction technique, i.e. deriving a contradicted fact while assuming the alternative argument is correct.

It could be tedious to give a rigid mathematical proof on why the greedy algorithm is correct here. Here we would like to present simply two arguments without detailed proofs:

If the source is not a subsequence of the target string, in no case will our greedy algorithm return a positive result.

If the source is indeed a subsequence of the target string (there could exist multiple solutions), then our greedy algorithm will return a positive result as well. For an obvious reason, our greedy algorithm does not exhaust all possible matches. However, one match suffices.

Algorithm

Following the recursive formulas that we presented before, it should be intuitive to implement a solution with recursion.

As a reminder, here is the formulas:

\text{isSubsequence(source, target)} = \left\{ \begin{array}{l} \text{isSubsequence(source[1:], target[1:])} \\ \text{isSubsequence(source, target[1:])} \end{array} \right.
isSubsequence(source, target)={ 
isSubsequence(source[1:], target[1:])
isSubsequence(source, target[1:])
​	
 


Note, the above implementations happen to comply with a particular form of recursion, called tail recursion, which is a runtime optimization technique that is supported in some programming languages such as C and C++.

For more details, one can refer to the article of tail recursion in our Explore card.

Complexity Analysis

Let |S|∣S∣ be the length of the source string, and |T|∣T∣ be the length of the target string.

Time Complexity: \mathcal{O}(|T|)O(∣T∣).

At each invocation of the rec_isSubsequence() function, we would consume one character from the target string and optionally one character from the source string.

The recursion ends when either of the strings becomes empty. In the worst case, we would have to scan the entire target string. As a result, the overall time complexity of the algorithm is \mathcal{O}(|T|)O(∣T∣).

Note, even when the source string is longer than the target string, the recursion would end anyway when we exhaust the target string. Hence, the number of recursions is not bounded by the length of the source string.

Space Complexity: \mathcal{O}(|T|)O(∣T∣)

The recursion incurs some additional memory consumption in the function call stack. As we discussed previously, in the worst case, the recursion would happen |T|∣T∣ times. Therefore, the overall space complexity is \mathcal{O}(|T|)O(∣T∣).

With the optimization of tail recursion, this extra space overhead could be exempted, due to the fact that the call stack is reused for all consecutive recursions. However, Python and Java do not support tail recursion. Hence, this overhead cannot be waived.



Approach 2: Two-Pointers
Intuition

Following the same intuition above, we could further optimize the space complexity of the previous solutions, by replacing the recursion with the iteration.

More specifically, we iterate through the source and target strings, respectively with a pointer.

Each pointer marks a position that we progress on the matching of the characters.

Algorithm

We designate two pointers for iteration, with the left pointer referring to the source string and the right pointer to the target string.

two-pointers

We move the pointers accordingly on the following two cases:

If source[left] == target[right]: we found a match. Hence, we move both pointers one step forward.

If source[left] != target[right]: no match is found. We then move only the right pointer on the target string.

The iteration would terminate, when either of the pointers exceeds its boundary.

At the end of the iteration, the result solely depends on the fact that whether we have consumed all the characters in the source string. If so, we have found a suitable match for each character in the source string. Therefore, the source string is a subsequence of the target string.


Complexity Analysis

Let |S|∣S∣ be the length of the source string, and |T|∣T∣ be the length of the target string.

Time Complexity: \mathcal{O}(|T|)O(∣T∣)

The analysis is the same as the previous approach.
Space Complexity: \mathcal{O}(1)O(1)

We replace the recursion with iteration. In the iteration, a constant memory is consumed regardless of the input.


Approach 3: Greedy Match with Character Indices Hashmap
Intuition

With the above two approaches under the belt, let us now look at the follow-up question raised in the problem description, which we cite as follows:

If there are lots of incoming SS, say S_1S 
1
​	
 , S_2S 
2
​	
 , ..., and you want to check one by one to see if TT has its subsequence. In this scenario, how would you change your code?

In the above scenario, we would expect several incoming source strings, but a constant target string. We are asked to match each of the source strings against the target string.

If we apply our previous algorithms, for each match, the overall time complexity would be \mathcal{O}(|T|)O(∣T∣).

In other words, regardless of the source strings, in the worst case, we have to scan the target string repeatedly, even though the target string remains the same.

Now with the bottleneck identified, we could ask ourselves if we could do something about it.

The reason why we scan the target string is to look for the next character that matches a given character in the source string. In essence, this is a lookup operation in the array data structure.

To speed up the lookup operation, the data structure of hashmap could come in handy, since it has a \mathcal{O}(1)O(1) time complexity for its lookup operation.

Indeed, we could build a hashmap out of the target string, with each unique character as key and the indices of its appearance as value.

hashmap

Moreover, we should pre-compute this hashmap once and then reuse it for all the following matches.

With this hashmap, rather than scanning through the entire target string, we could instantly retrieve all the relevant positions in the target string to look at, given a character from the source string.

Algorithm

Essentially, the algorithm with hashmap remains rather similar with our previous approaches, i.e. we still need to iterate through the source string to find the matches, and more importantly, we still do the match in the greedy manner.

First, we build a hashmap out of the target string. Each key is a unique character in the target string, e.g. a. Its corresponding value would be a list of indices where the character appears in the target string, e.g. [0, 3].

We then iterate through the source string.

This time, rather than keeping two pointers, we need only one pointer on the target string. The pointer marks our progress on the target string.

As we've seen from all the previous approaches, the pointer on the target string should move monotonically, i.e. in no case, we would move the pointer to an earlier position.

We use the pointer to check if an index is suitable or not. For instance, for the character a whose corresponding indices are [0, 3], we need to pick an index out of all the appearances as a match. Suppose at certain moment, the pointer is located at the index 1. Then, the suitable greedy match would be the index of 3, which is the first index that is larger than the current position of the target pointer.


Optimization

As one might notice, we added a last touch to the above algorithm to make it faster.

Given a list of indices for a matched character, in order to find the suitable index, we could simply do the linear search as we did in the above Java implementation.

Since the list of indices is ordered, due to the process of construction, we could also apply the binary search on the list to locate the desired index faster. As a comparison, we implemented this in the Python implementation.

Now hopefully, no one is puzzled with the keyword of binary search from the hints of the problem.

Complexity Analysis

Let |T|∣T∣ be the length of the target string, and |S|∣S∣ be the length of the source string.

Time Complexity: \mathcal{O}(|T| + |S| \cdot \log{|T|})O(∣T∣+∣S∣⋅log∣T∣).

First of all, we build a hashmap out of the target string, which would take \mathcal{O}(|T|)O(∣T∣) time complexity. But if we redesign the API to better fit the scenario of the follow-up question, we should put the construction of the hashmap in the constructor of the class, which should be done only once. The cost of this construction would be amortized by the following calls of string matches.

As the second part of the algorithm, we scan through the source string, and lookup the corresponding indices in the hashmap. The lookup operation in hashmap is constant. However, to find the suitable index would take either \mathcal{O}(|T|)O(∣T∣) with the linear search or \mathcal{O}(\log{|T|})O(log∣T∣) with the binary search. To summarize, this part would be bounded by \mathcal{O}(|S| \cdot \log{|T|})O(∣S∣⋅log∣T∣).

As one can see, the second part heavily depends on the distribution of the characters in the target string. If the characters are distributed evenly, the entries in the hashmap would have a shorter list of indices, which in return would shorten the search time. But in general, one could consider the approach with hashmap should be faster than the two-pointers approach, although their time complexities say otherwise.

Space Complexity: \mathcal{O}(|T|)O(∣T∣)

We built a hashmap that consists of the indices for each character in the target string. Hence, the size of values (indices) in hashmap would be |T|∣T∣. In the worst case, we might have as many keys as the values, i.e. each character corresponds to a unique index. In total, the space complexity of the hashmap would be \mathcal{O}(|T|)O(∣T∣).
Approach 4: Dynamic Programming
Intuition

Based on the description of the problem, it reminds us of a well-known problem called Edit Distance on LeetCode, which is also known as Levenshtein disance.

The problem of edit distance is to find the minimal number of edit operations to convert one string to another string. The permitted operations are deletion, insertion and replacement.

Intuitively, one can consider our subsequence problem as a simplified edit distance with only the deletion operation.

The classic solution to solve the edit distance problem is to apply the dynamic programming technique. Similarly, we should be able to solve our problem here with dynamic programming as well.

Algorithm

With dynamic programming, essentially we build a matrix (dp[row][col]) where each element in the matrix represents the maximal number of deletions that we can have between a prefix of source string and a prefix of the target string, namely source[0:col] and target[0:row].

dp table

In the above graph, we show an example of the dp matrix. For instance, for the element of dp[2][3] as we highlighted, it indicates that the maximal number of deletions (i.e. matches) that we can have between the source prefix ac and the target prefix abc is 2.

Suppose that we can obtain this dp matrix, the problem becomes simple.

Once we have the dp matrix, it boils down to see if we can have as many deletions as the number of characters in the source string, i.e. if we could consume the entire source string with the matches from the target string.

In other words, it suffices to examine the last row of the dp matrix (dp[len(source)]), to see if there is any number that is equal to the length of the source string.

In the following animation, we show how to calculate each element in the dp matrix.

Current
5 / 18
Since the problem of edit distance is a hard one and so with its solution, we invite you to check out our article of edit distance, which explains the solution in details.

Here we present a modified version of the edit distance solution, based on the above idea.


Complexity Analysis

Let |T|∣T∣ be the length of the target string, and |S|∣S∣ be the length of the source string.

Time Complexity: \mathcal{O}(|S| \cdot |T|)O(∣S∣⋅∣T∣)

We build a matrix of size |S| \cdot |T|∣S∣⋅∣T∣. In the worst case, we would need to iterate through each element in the matrix. Therefore, the overall time complexity of the algorithm is \mathcal{O}(|S| \cdot |T|)O(∣S∣⋅∣T∣).

It is not necessarily the case that we have to iterate through the entire matrix. As one notices, we do have an early exit condition while we fill the values in the matrix.

Generally speaking, the dynamic programming algorithms tend to be faster than other solutions, since it reuses the intermediate solutions rather than recalculating them. However, it is not the case here.

The DP solution here tries to calculate the solutions for all combinations of prefixes between the source and target strings. As a result, it is less efficient than the Greedy approach which has the time complexity of \mathcal{O}(|T|)O(∣T∣).

Space Complexity: \mathcal{O}(|S| \cdot |T|)O(∣S∣⋅∣T∣), since we build a matrix of size |S| \cdot |T|∣S∣⋅∣T∣.