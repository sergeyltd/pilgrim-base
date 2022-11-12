package org.pilgrim.leetcode.y2022;

public class SumThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++){
            int a = nums[i];
            
            target = -a;
            
            List<List<Integer>> list = twoSum(nums, i+1, target);
            
            while(a == nums[i+1] && i<nums.length-3){
                i++;
            }
            
            if(list == null || list.isEmpty()){
                continue;
            }
            
            res.addAll(list);
        }
        
        Iterator<List<Integer>> it = res.iterator();
        List<Integer> node = null;
        if(it.hasNext()) {
            node = it.next();
        }
        while (it.hasNext()) {
            List<Integer> item = it.next();
            if(node.get(0).equals(item.get(0))
               && node.get(1).equals(item.get(1))
               && node.get(2).equals(item.get(2)))
            {
                it.remove();
            }
            else{
                node = item;
            }
        }
        
        return res;
    }
    
    private List<List<Integer>> twoSum(int[] arr, int start, int target){
        List<List<Integer>> lists = new ArrayList<>();
        
        // Traverse array from both sides
        int i = start;
        int j = arr.length - 1;
        while(i < j){
            int s = arr[i] + arr[j];
            if(target == s){
                List<Integer> list = new ArrayList<>();
                list.add(-target);
                list.add(arr[i]);
                list.add(arr[j]);
                
                Collections.sort(list);

                lists.add(list);
                
                i++;
                j--;
            }
            else if(target > s){
                i++;
                while(i < j && arr[i] == arr[i+1] && arr[i]*2 != target){
                    i++;
                }
            }
            else if(target < s){
                j--;
                while(i < j && arr[j] == arr[j - 1] && arr[j]*2 != target){
                    j--;
                }
            }
        }
        
        return lists;
    }
}

/**
 * 
 * 
 * [[-82,-11,93],[-82,13,69],[-82,17,65],[-82,21,61],[-82,26,56],[-82,33,49],[-82,34,48],[-82,36,46],[-70,-14,84],[-70,-6,76],[-70,1,69],[-70,13,57],[-70,15,55],[-70,21,49],[-70,34,36],[-66,-11,77],[-66,-3,69],[-66,1,65],[-66,10,56],[-66,17,49],[-49,-6,55],[-49,-3,52],[-49,1,48],[-49,2,47],[-49,13,36],[-49,15,34],[-49,21,28],[-43,-14,57],[-43,-6,49],[-43,-3,46],[-43,10,33],[-43,12,31],[-43,15,28],[-43,17,26],[-29,-14,43],[-29,1,28],[-29,12,17],[-29,-14,43],[-29,1,28],[-29,12,17],[-14,-3,17],[-14,1,13],[-14,2,12],[-11,-6,17],[-11,1,10],[-3,1,2]]
 * [[-82,-11,93],[-82,13,69],[-82,17,65],[-82,21,61],[-82,26,56],[-82,33,49],[-82,34,48],[-82,36,46],[-70,-14,84],[-70,-6,76],[-70,1,69],[-70,13,57],[-70,15,55],[-70,21,49],[-70,34,36],[-66,-11,77],[-66,-3,69],[-66,1,65],[-66,10,56],[-66,17,49],[-49,-6,55],[-49,-3,52],[-49,1,48],[-49,2,47],[-49,13,36],[-49,15,34],[-49,21,28],[-43,-14,57],[-43,-6,49],[-43,-3,46],[-43,10,33],[-43,12,31],[-43,15,28],[-43,17,26],[-29,-14,43],[-29,1,28],[-29,12,17],[-14,-3,17],[-14,1,13],[-14,2,12],[-11,-6,17],[-11,1,10],[-3,1,2]]
 * 
 * 
 */
