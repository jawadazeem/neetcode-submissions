class Solution {
    public boolean isAnagram(String s, String t) {
        int[] wahoo = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i=0; i<s.length(); i++) {
            int c = s.charAt(i) -'a';
            wahoo[c]++;
        }

        for (int i=0; i<t.length(); i++) {
            int c = t.charAt(i) -'a';
            wahoo[c]--;
        }

        for (int i=0; i<26; i++) {
            if (wahoo[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
