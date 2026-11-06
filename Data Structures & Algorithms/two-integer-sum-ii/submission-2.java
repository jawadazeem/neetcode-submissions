class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result;
        int l = 0;
        int r = numbers.length-1;
        while (l < r) {
            int li = numbers[l];
            int ri = numbers[r];
            if (li + ri == target) {
                return new int[] {l+1, r+1};
            } else if (li + ri < target) {
                l++;
            } else if (li + ri > target) {
                r--;
            }
        }

        return new int[] {0, 0};
    }
}
