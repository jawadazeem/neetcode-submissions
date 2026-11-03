class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //. number , times it appeared
        Map<Integer, Integer> map = new HashMap<>();
        //.  bucket list. This stores a list of numbers that are the same in another list.
        List<Integer>[] list = new List[nums.length + 1];
        int[] result = new int[k];

        // fill the map
        for (int i=0; i<nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }

        Set<Integer> keyset = map.keySet();
        for (Integer key : keyset) {
            Integer num = key;
            Integer freq = map.get(key);

            if (list[freq] == null) {
                List<Integer> temp = new ArrayList<>();
                temp.add(num);
                list[freq] = temp;
            } else {
                List<Integer> temp = list[freq];
                temp.add(num);
                list[freq] = temp;
            }
        }

        int kct=0;
        for (int i=list.length-1; i>0; i--) {
            if (kct == k) {
                return result;
            }

            if (list[i] != null) {
                for (int j=0; j<list[i].size(); j++) {
                    result[kct] = list[i].get(j);
                    kct++;
                }
            }
        }

        return result;
    }
}
