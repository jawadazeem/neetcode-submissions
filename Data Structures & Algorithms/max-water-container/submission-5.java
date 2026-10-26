class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int currArea = 0;
        int maxArea = 0;

        while (left < right) {
            currArea = Math.min(heights[left], heights[right]) * (right-left);
            if (currArea > maxArea) {
                maxArea = currArea;
            }

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
