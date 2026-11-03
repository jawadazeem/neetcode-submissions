class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();

        for (String str : strs) {
            int len = str.length();
            result.append(len).append("#").append(str);
        }

        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int len = str.length();

        int slate = 0;
        for (int i=0; i<str.length(); i++) {
            
            if (str.charAt(i) == '#') {
                int numIndices = Integer.parseInt(str.substring(slate, i));
                result.add(str.substring(i+1, i+1+numIndices));
                slate = i+1+numIndices;
                i=slate-1;
            }
        }

        return result;
    }
}
