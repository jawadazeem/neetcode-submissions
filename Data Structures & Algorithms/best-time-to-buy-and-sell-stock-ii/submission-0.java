class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        
        int l = 0;
        int r = 1;

        boolean first = true;
        int runningTotal = 0;
        int curr = 0;
        while (r < prices.length) {
            if (prices[r]-prices[l] < 0) {
                l++;
                r++;
                continue;
            }

            while (r < prices.length && prices[r] - prices[l] > curr) {
                curr = prices[r] - prices[l];
                r++;
            }

            runningTotal += prices[r-1] - prices[l];
            curr = 0;
            l = r;
            r = l+1;
        }

        return runningTotal;
    }
}