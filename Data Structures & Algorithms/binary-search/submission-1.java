class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // 1. Calculate the 'Surgical' mid (no overflow!)
            int mid = low + (high-low)/2;
            // 2. If nums[mid] == target -> You found it!
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid+1;
            } else if (target < nums[mid]) {
                high = mid-1;
            }
            // 3. If target is GREATER than nums[mid] -> Move 'low'
            
            // 4. If target is SMALLER than nums[mid] -> Move 'high'

        }
        return -1;
    }
}