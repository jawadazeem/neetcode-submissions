class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int[] completionSpeeds = new int[piles.length];
        
        int low = 1;
        int high = 0;
        for (int i=0; i<piles.length; i++) {
            high = Math.max(high, piles[i]);
        }

        // for a given speed, if piles[i] < speed, used up 1 hr
        // else, (bananas + speed - 1)/speed
        int lowestPriceTechnicallyAcceptable = high;
        while (low <= high) {
            int mid = low + (high-low)/2;

            if (calc(piles, mid) <= h) {
                high = mid-1;
                lowestPriceTechnicallyAcceptable = mid;
            } else if (calc(piles, mid) > h) {
                low = mid+1;
            }
        }

        return lowestPriceTechnicallyAcceptable;
    }

    private long calc(int[] piles, int speed) {
        long t=0;
        for (int i=0; i<piles.length; i++) {          
            if (piles[i] < speed) {
                t++;
                continue;
            }           
            
            t += (piles[i] + speed - 1)/speed;
        }

        return t;
    }
}
