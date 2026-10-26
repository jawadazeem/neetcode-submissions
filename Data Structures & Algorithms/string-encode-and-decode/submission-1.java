class Solution {

    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : strs) {
            stringBuilder.append(s.length() + "#" + s);
        }

        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        // i represents the beginning of a number, j the end of the number
        int i=0;
        while (i<str.length()) {
            int j=i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j)); 
            i = j+1;  
            result.add(str.substring(i, i+len));         
            i = i + len;  
        }

        return result;
    }
}
