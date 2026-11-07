class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        
        int max = 0;
        int curr;
        for (int num : set) {
            curr = 0;
            if (!set.contains(num-1)) {
                while (set.contains(num+curr)) {
                    curr++;
                }

                if (max < curr) {
                    max = curr;
                }
            }
        }   

        return max;
    }
}
