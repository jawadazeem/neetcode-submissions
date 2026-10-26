class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> stack = new ArrayDeque<>();
        int len = position.length;
        double[] t = new double[len];

        // 1. Create a 2D array: [position][time]
        double[][] cars = new double[len][2];
        for (int i = 0; i < len; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // 2. Sort by position (index 0) DESCENDING (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        // 3. Now your stack logic will actually work
        for (int i = 0; i < len; i++) {
            double currentTime = cars[i][1];
            if (stack.isEmpty() || currentTime > stack.peek()) {
                stack.push(currentTime);
            }
        }    

        return stack.size();
    }
}
