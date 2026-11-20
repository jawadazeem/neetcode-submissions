class Solution {
    public int removeElement(int[] nums, int val) {
        int res = nums.length;
        int[] arr = new int[res];

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == val) {
                res--;
                nums[i] = -1;
            } else {
                arr[i - (nums.length - res)] = nums[i];
            }
        }
        

        for (int i=0; i<arr.length; i++) {
            int tmp = i;
            nums[i] = arr[i];
        }

        return res;
    }
}