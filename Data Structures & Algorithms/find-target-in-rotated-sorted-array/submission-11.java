class Solution {
    public int search(int[] nums, int target) {
        // [3,4,5,6,1,2] target 1
        // [4,5,1,2,3] target 5 
        // [5,1,3]  target 5
        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] == target) {
                return mid;
            }

            // ARE WE IN THE LEFT OR RIGHT SORTED PORTION?
            if (nums[low] <= nums[mid]) { // LEFT
                if (target > nums[mid] || target < nums[low]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } else { // RIGHT
                if (target < nums[mid] || target > nums[high]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}
