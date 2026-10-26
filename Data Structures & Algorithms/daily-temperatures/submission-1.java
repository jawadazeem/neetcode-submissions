class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        // Moving Right to Left
        for (int i = temperatures.length - 1; i >= 0; i--) {
            
            // 1. Kick out all future days that are COLDER or EQUAL to today.
            // They are useless to us and anyone to our left.
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            
            // 2. If the stack isn't empty, the top of the stack is our 
            // NEXT WARMER DAY in the future.
            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i; // Distance between today and that future day
            }
            
            // 3. Put today on the stack so days to our left can check us.
            stack.push(i);          
        }

        return result;
    }
}