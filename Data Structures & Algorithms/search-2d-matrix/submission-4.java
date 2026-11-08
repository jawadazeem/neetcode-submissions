class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int hi = (n*m)-1;
        int lo = 0;

        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int num = matrix[mid/n][mid % n];

            if (num > target) {
                hi = mid-1;
            } else if (num < target) {
                lo = mid+1;
            } else {
                return true;
            }
        }

        return false;
    }
}
