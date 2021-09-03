class Solution {
    public int maxArea(int[] height) {
        int first = 0;
        int last = height.length - 1;
        int area = 0;

        while (first < last) {
            int tempArea = (last - first) * Math.min(height[first], height[last]);

            area = Math.max(tempArea, area);

            if (height[first] < height[last]) {
                first += 1;
            } else {
                last -= 1;
            }
        }

        return area;
    }
}
