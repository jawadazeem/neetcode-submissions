class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> stack = new ArrayDeque<>();
        int len = position.length;
        double[][] tuple = new double[len][2];
        
        // fill 2d arr
        for (int i=0; i<len; i++) {
            tuple[i][0] = position[i];
            tuple[i][1] = (double)(target-position[i])/speed[i];
        }

        Arrays.sort(tuple, (a,b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < len; i++) {
            double currentTime = tuple[i][1];
            if (stack.isEmpty() || currentTime > stack.peek()) {
                stack.push(currentTime);
            }
        }

        return stack.size();
    }
}
