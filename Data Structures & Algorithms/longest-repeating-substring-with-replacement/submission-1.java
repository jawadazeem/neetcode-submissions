class Solution {
    public int characterReplacement(String s, int k) {
        /*
         * Plan: Only valid if windowSize - maxOcc > k;
         */

        int[] arr = new int[26];

        int l = 0;
        int max = 0;
        for (int r=0; r<s.length(); r++) {
            arr[s.charAt(r) - 'A']++;

            int maxOccur = 0;
            for (int i=0; i<arr.length; i++) {
                maxOccur = Math.max(arr[i], maxOccur);
            }
            
            if ((r-l+1) - maxOccur <= k) {
                max = Math.max(max, r-l+1);
            } else {
                arr[s.charAt(l) - 'A']--;
                l++;
            }
        }

        return max;
    }
}
