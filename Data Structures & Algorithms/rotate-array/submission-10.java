class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0) return;
        if (nums.length == 0) return;
        k = k % nums.length;

        int[] nums2 = new int[nums.length];
        int idx = 0;
        
        for (int i = nums.length - k; i < nums.length; i++) {
            nums2[idx++] = nums[i];
        }

        for (int i = 0; i < nums.length - k; i++) {
            nums2[idx++] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums2[i];
        }
    }
}