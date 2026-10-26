class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numComplement = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int c = target-nums[i];
            if (numComplement.containsKey(c)) {
                return new int[]{numComplement.get(c),i};
            } else {
                numComplement.put(nums[i], i);
            }
        }
        return new int[]{0,0};
    }
}
