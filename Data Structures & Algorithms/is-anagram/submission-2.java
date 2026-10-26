class Solution {
    /**
     * This is a much more efficient solution to the problem as compared to
     * turning the Strings into arrays and sorting them. In that case, the
     * time complexity is O(nlog(n)). In this case, where we are using a HashMap,
     * it is only O(n) (linear time).
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> ctr = new HashMap<>();

        if (s.length() != t.length()) return false;

        for (int i=0; i<s.length(); i++) {
            ctr.compute(s.charAt(i), (k, v) -> v == null ? 1 : v+1);
        }
        
        for (int i=0; i<t.length(); i++) {
            ctr.compute(t.charAt(i), (k, v) -> v == null ? -1 : v-1);
        }
        
        for (Character c : ctr.keySet()) {
            if (ctr.get(c) != 0) {
                return false;
            }
        }

        return true;      
    }
}
