class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;
        
        for (int i=0; i<piles.length; i++) {
            high = Math.max(piles[i], high);
        }

        int lpta = high;
        while (low <= high) {
            int mid = low + (high-low)/2; // mid represents the rate, k.

            if (calcTime(piles, mid) > h) {
                low = mid + 1;
            } else if (calcTime(piles, mid) <= h) {
                high = mid - 1;
                lpta = mid;
            }
        }

        return lpta;
    }

    private int calcTime(int[] piles, int speed) {
        int t = 0;
        for (int i=0; i<piles.length; i++) {
            if (piles[i] < speed) {
                t+=1;
            } else {
                t+=Math.ceil((double)piles[i]/speed);
            }
        }

        return t;
    }
}
