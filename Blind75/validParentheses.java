/******************************************************

Algorithm:
1. Add closing brackets to the stack whenever opening
brackets are seen in the string
2. If closing brackets are seen in the string, pop off
opening brackets. If stack is already empty or the alignment
is off, then it is not a valid string
3. For a valid string, ultimately stack will be empty.

*******************************************************/

class Solution {
    private Map<Character, Character> charMap = Map.of(
		'(', ')',
		'[', ']',
		'{', '}'
    );

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

		Stack<Character> charStack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (charMap.containsKey(c)) {
				charStack.push(charMap.get(c));
			} else {
				if (charStack.empty() || c != charStack.pop()) return false;
			}
		}

		return charStack.empty();
    }
}
