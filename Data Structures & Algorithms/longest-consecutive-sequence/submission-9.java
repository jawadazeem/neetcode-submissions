class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int registerMax = 0;
        int registerCurr = 1;
        for (int i=0; i<nums.length; i++) {
            if (i<nums.length-2 && nums[i] + 1 == nums[i+1]) {
                registerCurr++;
            } else if (i<nums.length-2 && nums[i] == nums[i+1]) {
                continue; 
            } else if (i == nums.length-2 && registerCurr >= registerMax) {
                return nums[nums.length-2] + 1 == nums[nums.length-1] ? registerCurr+1 : registerCurr;
            } else {
                if (registerCurr > registerMax) {
                    registerMax = registerCurr;
                }
                registerCurr = 1;
            }
        }

        return registerMax;
    }
}
