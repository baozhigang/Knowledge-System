class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        HashMap<Character, Character> pairs = new HashMap<Character, Character>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            Character ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
