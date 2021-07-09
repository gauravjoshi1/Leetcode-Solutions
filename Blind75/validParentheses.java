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
