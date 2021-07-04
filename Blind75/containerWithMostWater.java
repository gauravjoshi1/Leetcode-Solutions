/************************************************

The trick is to remember that for max_area,
we need to have maximum width as possible.

To keep the width max, start from max width,
shrink the width using two pointers as
required.

Time Complexity: O(n)
Space Complexity: O(1)

**********************************************/

class Solution {
	public int maxArea(int[] height) {
		int first = 0;
		int last = height.length - 1;
		int area = 0;

		while (first < last) {
			int tempArea = Math.min(height[first], height[last]) * (last - first);
			area = Math.max(area, tempArea);

			if (height[first] < height[last]) {
				first += 1;
			} else {
				last -= 1;
			}
		}

		return area;
	}
}
