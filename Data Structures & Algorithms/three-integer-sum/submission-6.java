class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * Second solution using hints.
         */
        List<List<Integer>> tuples = new ArrayList<>();

        Arrays.sort(nums);    
        
        // i is the target we are aiming for
        for (int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                int threeSum = nums[left] + nums[right] + nums[i];
                if (threeSum == 0) {
                    tuples.add(Arrays.asList(
                        nums[left], 
                        nums[right], 
                        nums[i]
                    ));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (threeSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
 
        return tuples;
    }
}
