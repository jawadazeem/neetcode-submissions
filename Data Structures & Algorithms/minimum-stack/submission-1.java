class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> operandStack = new ArrayDeque<>();

    public MinStack() {
        stack = new ArrayDeque<>();
        operandStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if (operandStack.isEmpty()) {
            operandStack.push(val);
        } else {
            if (val < operandStack.peekFirst()) {
                operandStack.push(val);
            } else {
                operandStack.push(operandStack.peekFirst());
            }
        }
    }
    
    public void pop() {
        stack.pop();
        operandStack.pop();
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return operandStack.peekFirst();
    }
}
