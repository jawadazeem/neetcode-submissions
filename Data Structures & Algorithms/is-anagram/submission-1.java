class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> ctr = new HashMap<>();

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
