class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
         * Plan: take s1's values and put them in a hashmap where:
         * K = char, V = freq
         * In s2, do a sliding window such that r - l + 1 == s1.length().
         */

        // fail fast
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();

        // populate map with s1's vals
        for (int i=0; i<s1.length(); i++) {
            map.compute(s1.charAt(i), (key, val) -> map.containsKey(key) ? val+1 : 1);
        }

        int l = 0;
        for (int r=s1.length()-1; r<s2.length(); r++) {
            map1.clear();
            for (int i=l; i<=r; i++) {
                map1.compute(s2.charAt(i), (key, val) -> map1.containsKey(key) ? val+1 : 1);
            }

            if (map.equals(map1)) {
                return true;
            }

            l++;
        }

        return false;
    }
}
