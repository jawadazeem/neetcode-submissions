class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length-1;
        int boats = 0;

        while (r >= 0 && people[r] == limit) {
            boats += 1;
            r--;
        }

        // [2, 2, 3, 4, 5, 5] limit 5

        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                boats += 1;
                l++;
                r--;
            } else {
                boats += 1;
                r--;
            }
        }

        return boats;
    }
}