class Solution {
    public boolean isValid(String s) {
        // fail fast
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (opening(c)) {
                stack.push(c);
            } else {
                // closing, no matching opening to its left.
                if (stack.isEmpty()) {
                    return false;
                }
                
                if (op(stack.pop()) != c) {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }

    private static char op(char c) {
        if (c == '[') {
            return ']';
        } else if (c == '{') {
            return '}';
        } else if (c == '(') {
            return ')';
        } else if (c == ')') {
            return '(';
        } else if (c == ']') {
            return '[';
        } else {
            return '{';
        }
    }

    private static boolean opening(char c) {
        if (c == '[' || c == '(' || c == '{') {
            return true;
        }

        return false;
    }
}
