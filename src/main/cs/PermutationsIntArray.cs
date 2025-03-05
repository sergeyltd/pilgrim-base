/// <summary>
/// Given an array nums of distinct integers,
//  return all the possible permutations.
//  You can return the answer in any order.
/*
Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/
/// </summary>

public class PermutationsIntArray {
    List<IList<int>> ans;
    public IList<IList<int>> Permute(int[] nums) {
        ans = new();
        Permute(nums, 0);

        return ans;
    }

    private void Permute(int[] nums, int index)
    {
        // Recursion exit
        if(index == nums.Length)
        {
            ans.Add(new List<int>(nums));
            return;
        }

        for(int i=index; i<nums.Length; i++)
        {
            // Swap numbers
            int t = nums[i];
            nums[i] = nums[index];
            nums[index] = t;

            Permute(nums, index+1);

            // Return back
            nums[index] = nums[i];
            nums[i] = t;
        }
    }
}