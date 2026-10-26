class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        boolean flag = true;
        
        for (int i=0; i<nums.length; i++) {
            flag = set.add(nums[i]);
            
            if (flag == false) {
                return true;
            }
        }

        return false;
    }
}