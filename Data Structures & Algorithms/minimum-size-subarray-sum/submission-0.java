class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length+1;
        int currSum = 0;
        int l = 0;
        
        for (int i=0; i<nums.length; i++) {
            currSum += nums[i];
            while (currSum >= target) {
                min = Math.min(min, i-l+1);
                currSum -= nums[l];
                l++;
            }
        }

        return min == nums.length+1 ? 0 : min;
    }
}