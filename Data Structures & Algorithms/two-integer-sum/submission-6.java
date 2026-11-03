class Solution {
    public int[] twoSum(int[] nums, int target) {
        //. val.     index
        Map<Integer, Integer> map1 = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if (map1.containsKey(complement)) {
                int qindex = map1.get(complement);
                return new int[] {qindex, i};
            } else {
                map1.put(nums[i], i);
            }
        }

        return new int[] {0, 0};
    }
}
