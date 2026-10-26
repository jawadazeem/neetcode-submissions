/**
 * Solved using Stack in conjunction with HashMap
 */

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char c : s.toCharArray()) {

            if (map.containsValue(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (top != map.get(c)) {
                    return false;
                }
            }
        }

        // At the end, stack must be empty
        return stack.isEmpty();
    }
}
