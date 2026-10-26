class Solution {
    public int longestConsecutive(int[] nums) {
        /**
         * Use a HashSet to store dump all of the numbers. Find the lowest number
         * in the HashSet by looking to the left of a given number, checking for n-1.
         * Once the smallest number is found, look for n+1, n+2, until we reach a max.
        */
        HashSet<Integer> set = new HashSet<>();
        int currLargestSeq = 0;
        int largestSeq = 0;

        for (int n : nums) {
            set.add(n);
        }

        for (int n : set) {
            if (!set.contains(n-1)) {
                int j=0;
                while (set.contains(n+j)) {
                    currLargestSeq++;
                    j++;
                }
            }

            if (currLargestSeq > largestSeq) {
                largestSeq = currLargestSeq;
            }

            currLargestSeq = 0;
        }

        return largestSeq;
    }
}
