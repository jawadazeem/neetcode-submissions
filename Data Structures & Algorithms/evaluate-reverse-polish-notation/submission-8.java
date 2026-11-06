class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for (String t : tokens) {

            if (t.equals("+") || t.equals("*") || t.equals("-") || t.equals("/")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int x = performCalc(b, a, t.charAt(0));
                stack.push(String.valueOf(x));

            } else {
                stack.push(String.valueOf(t));
            }
        }

        return Integer.valueOf(stack.pop());
    }

    private int performCalc(int a, int b, char op) {
        if (op == '+') {
            return a+b;
        } else if (op == '*') {
            return a*b;
        } else if (op == '-') {
            return a-b;
        } else {
            return a/b;
        }
    }
}
