class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[nums.length];

        // take the nums and store the num as the key, and how much it
        // appears as the value. As we traverse the array, we will simply
        // add to the existing value if it exists
        // at the end, we perform a final traversal through the hashmap to sort all of the
        // keys in a list. We will store them and sort them based off the freq of the val
        // we will select the largest.

        // populate map
        for (int i : nums) {         
            map.merge(i, 1, Integer::sum);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) break;
                }
            }
        }
    
        return result;
    }
}
