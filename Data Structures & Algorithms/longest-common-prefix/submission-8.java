class Solution {
    public String longestCommonPrefix(String[] strs) {
        String base = strs[0];

        for (int i=0; i<strs.length; i++) {
            int k = 0;
            while (k<base.length()) {
                if (strs[i].length() == 0) return "";

                if (strs[i].length() < base.length()) {
                    base = base.substring(0, strs[i].length());
                }

                if (strs[i].charAt(k) != base.charAt(k)) {
                    base = base.substring(0, k);
                    break;
                }
                k++;
            }
        }

        return base;
    }
}