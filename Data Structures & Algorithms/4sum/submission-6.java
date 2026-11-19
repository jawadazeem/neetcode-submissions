class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        // [1,0,-1,0,-2,2]
        // [-2, -1, 0, 0, 1, 2]

        for (int i=0; i<nums.length-3; i++) {
            for (int j=i+1; j<nums.length-2; j++) {
                int l = j+1;
                int r = nums.length-1;
                while (l < r) {
                    long curr = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if (curr == target) {
                        List<Integer> ans = List.of(nums[i], nums[j], nums[l], nums[r]);
                        if (set.add(ans)) result.add(ans);
                        l++;
                        r--;
                    } else if (curr < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return result;
    }
}