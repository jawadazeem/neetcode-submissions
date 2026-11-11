class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        int mid = l + (r-l)/2;
        int result = nums[mid];
        while (l <= r) {
            if (nums[l] < nums[r]) {
                result = Math.min(result, nums[l]);
                break;
            }

            mid = l + (r-l)/2;

            if (nums[mid] < result) {
                result = nums[mid];
            }

            if (nums[l] <= nums[mid]) {
                
                l = mid+1;
            } else {
                r = mid-1;

            }
        }

        return result;
    }
}
