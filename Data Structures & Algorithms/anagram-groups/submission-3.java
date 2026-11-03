class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        //. data.  index that group belongs to in result
        Map<List<Integer>, Integer> registry = new HashMap<>();

        for (int i=0; i<strs.length; i++) {
            List<Integer> arr = new ArrayList<Integer>(Collections.nCopies(26, 0));
            
            String curr = strs[i];
            
            // populates array
            for (int j=0; j<curr.length(); j++) {
                int letter = curr.charAt(j) - 'a';
                int currNum = arr.get(letter);
                arr.set(letter, currNum+1);
            }

            // if we have it, add index to map for group
            if (registry.containsKey(arr)) {
                int group = registry.get(arr);
                result.get(group).add(strs[i]);
            } else {
                registry.put(arr, result.size());
                List<String> data = new ArrayList<>(Arrays.asList(strs[i]));
                result.add(data);
            }
        }

        return result;
    }
}
