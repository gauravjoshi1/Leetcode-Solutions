import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    // TODO: Write your code here
    if (k > str.length()) return str.length();

	int windowLength = 0;
	int start = 0;

	// HashMap stores maxLength for character from arr
	HashMap<Character, Integer> windowMap = new HashMap<>();

	for (int end = 0; end < str.length(); end++) {
		char expandWindowChar = str.charAt(end);
		windowMap.put(expandWindowChar, windowMap.getOrDefault(expandWindowChar, 0) + 1);

		// shrink the window if it expands more than K items
		while (windowMap.size() > k) {
			char shrinkWindowChar = str.charAt(start);
			windowMap.put(shrinkWindowChar,windowMap.get(shrinkWindowChar) - 1);
			if (windowMap.get(expandWindowChar) == 0) {
				windowMap.remove(expandWindowChar);
			}

			start = start + 1;
		}

		windowLength = Math.max(windowLength, end - start + 1);
	}


    return windowLength;
  }
}
