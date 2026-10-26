/**
 * Entirely my own logic. It is a brute forced solution, O(n^2), not horrible,
 * but far from ideal nonetheless.
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
    
        for (int i=0; i<nums.length; i++) {
            int indexProd = 1;
            for (int j=0; j<nums.length; j++) {
                if (i != j) {
                    indexProd *= nums[j];
                }
            }
            result[i] = indexProd;
        }

        return result;
    }
}  
