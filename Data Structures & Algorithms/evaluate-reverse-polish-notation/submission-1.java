class Solution {
    public int evalRPN(String[] tokens) {
        /**
         * While the traversing the tokens, if we get an operand, push to stack, 
         * if we get an operator, take the (two) operands and perform the operation.
         * Push it to the stack once again, allow the loop to continue. Repeat until
         * we reach the end of token.
         */
        Deque<Integer> stack = new ArrayDeque<>();

        for (String t : tokens) {
            if (t.equals("+") || t.equals("*") || t.equals("-") || t.equals("/")) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                String operator = t;
                int result;

                if (t.equals("+")) {
                    result = operand1 + operand2;
                } else if (t.equals("-")) {
                    result = operand2 - operand1;
                } else if (t.equals("*")) {
                    result = operand1 * operand2;
                } else if (t.equals("/")) {
                    result = operand2/operand1;
                } else {
                    result = 0; // should never be true
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(t));   
            }
        }

        return stack.pop();
    }
}
