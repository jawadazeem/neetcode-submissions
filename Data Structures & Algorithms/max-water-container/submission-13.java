class Solution {
    public int maxArea(int[] heights) {
        /*
         * The goal is to move the shorter one inward so long the next one is taller
         */

         int l = 0;
         int r = heights.length - 1;
         int maxHeight = 0;
         int currHeight = 0;

         while (l < r) {
            int lh = heights[l];
            int rh = heights[r];

            int bottleNeck = Math.min(lh, rh);
            currHeight = bottleNeck*(r-l);
            if (currHeight > maxHeight) {
                maxHeight = currHeight;
            }

            if (lh < rh && l+1 != r) {
                l++;
            } else if (rh < lh && r-1 != l) {
                r--;
            } else {
                r--;
            }
         }

         return maxHeight;
    }
}
