class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            map.compute(curr, (k, v) -> v == null ? 1 : v+1);
        }

        for(int i=0; i<t.length(); i++) {
            char curr = t.charAt(i);
            if (map.get(curr) == null) {
                return false;
            } if (map.get(curr) == 1) {
                map.remove(curr);
            } else {
                map.put(curr, map.get(curr)-1);
            }
        }

        return map.isEmpty();
    }
}
