class Solution {
    public int search(int[] nums, int target) {
        return find(nums, 0, nums.length-1, target);
    }

    public static int find(int[] nums, int low, int high, int target) {
        int mid = (low + high)/2;

        if (low > high) {
            return -1;
        }

        if (target > nums[mid]) {
            return find(nums, mid+1, high, target);
        } else if (target < nums[mid]) {
            return find(nums, low, mid-1, target);
        } else if (target == nums[mid]) {
            return mid;
        }

        return -1;
    }
}
