/*****************************************************************

Sliding Window Problem:
->	Use two pointers left and right to expand and shrink window
-> 	Keep expanding the number of values considered using right ptr
	  until you find a duplicate
-> 	Once you find a duplicate, start shrinking the window using the
	  left ptr until you remove the duplicate
->	After every successful expand, update max length of sub string
-> 	Max Length is highest window length found between two pointers.

Time Complexity: *** O(n)
Space Complexity: O(m) or O(1) as per assumption
				  since 128 is constant space for ASCII but can
				  potentially change for UTF 16.


*** Asymptotic Time is O(n) but we are performing O(2n) operations
in the worst case (all duplicate values. In that case we check left
and right for each element of array).

This can be optimized as follows:
	-> Use Object array instead of int array.
	-> If Object index at a location is not uninitialized (meaning duplicate value),
		and is in the given bounds (less than right, greater than left),
		then move left pointer to right pointer + 1 at that instance.

	Example: aaaaa

	Here the current solution will check all the a's twice.
	In the optimized solution, left ptr will directly move to index 2
	then to index 4 and so on.

	Right ptr will end up checking O(n) but left ptr doesn't
	have any redundant operations.

******************************************************************/

class Solution {
	public int lengthOfLongestSubstring(String s) {
		int left = 0;
		int right = 0;
		int maxCount = 0;
		int[] chars = new int[128];

		while (right < s.length()) {
			int rightVal = s.charAt(right);
			chars[rightVal] += 1;

			// keep shrinking the window until you remove duplicate
			while (chars[rightVal] > 1) {
				int leftVal = s.charAt(left);
				chars[leftVal] -= 1;
				left += 1;
			}

			maxCount = Math.max(maxCount, right - left + 1);
			right += 1;
		}

		return maxCount;
	}
}
