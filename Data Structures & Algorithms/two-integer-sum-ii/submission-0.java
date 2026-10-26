class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = numbers.length;
        int i=0;
        int j=l-1;
        
        while (i<j) {
            if (numbers[i]+numbers[j] == target) {
                return new int[]{i+1,j+1};
            } else if (numbers[i]+numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return new int[]{};
    }
}
