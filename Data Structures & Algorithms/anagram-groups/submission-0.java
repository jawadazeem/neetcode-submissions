class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> ctr = new HashMap<>();

        // traverse array
        for (String str : strs) {
            // sort string at index i
            char[] cs = str.toCharArray();
            Arrays.sort(cs);

            // as we sort a string, and proceed to the next string,
            // we check if the next string matches the previous string
            // check if any keys match cs, if yes, put in a list of its val, if not
            // make new key of cs
            String csString = String.valueOf(cs);
            if (ctr.containsKey(csString)) {
                ctr.compute(csString, (k,v) -> {
                    if (v == null) {
                        v = new ArrayList<>();
                    }

                    v.add(str);
                    return v;
                });
            } else {
                ctr.put(csString, new ArrayList<>() {{ 
                    add(str);
                }});
            }
        }

        for (String str : ctr.keySet()) {
            result.add(ctr.get(str));
        }
        return result;
    }
}
