package leetcode.wigglesort;


public class Solution {
	public void wiggleSort(int[] nums) {
        for(int i = 1; i<nums.length; i++) {
            if((i%2) == 1 && nums[i] <= nums[i-1]) {
                for(int j = i; j<nums.length; j++) {
                    if(nums[i-1] < nums[j]) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }else if ((i%2) == 0 && nums[i] >= nums[i-1]) {
                for(int j = i; j<nums.length; j++) {
                    if(nums[i-1] > nums[j]) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }else {
            	continue;
            }
      
        }
    }
    public void swap(int[] nums, int index , int index2) {
        int tmp = nums[index];
        nums[index] = nums[index2];
        nums[index2] = tmp;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = new int[]{1,5,1,1,6,4};
		s.wiggleSort(arr);
		arr.toString();
	}

}
