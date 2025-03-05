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

public class PermutationsIntArrayV2 {
    IList<IList<int>> output = new List<IList<int>>();
    public IList<IList<int>> Permute(int[] nums) {
        this.Permute(nums, nums.Length, new LinkedList<int>());
        return output;
    }

    private void Permute(int[] a, int k, LinkedList<int> list){
        if (k == 0){
            output.Add(list.ToList());
        }

        for (int i=0; i<a.Length; i++){
            list.AddLast(a[i]);

            int[] b = new int[a.Length - 1];
            for(int j=0, e=0; j<a.Length; j++){
                if (i == j){
                    continue;
                }

                b[e++] = a[j];
            }

            this.Permute(b, k-1, list);
            list.RemoveLast();
        }
    }
}