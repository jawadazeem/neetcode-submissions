class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low)/2;

            if (nums[mid] > target) {
                high = mid-1;
            } else if (nums[mid] < target) {
                low = mid+1;
            } else {
                return mid;
            }
        }

        if (mid == 0) {
            return target < nums[0] ? 0 : 1;
        } else if (mid == nums.length-1) {
            return target > nums[nums.length-1] ? nums.length : nums.length-1;
        } else {
            if (target > nums[mid]) {
                return mid+1;
            } else {
                return mid;
            }
        }
    }
}