class Solution {
	public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length <= 1) return intervals;

		ArrayList<int[]> listOfIntervals = new ArrayList<>();
		int[] intervalPtr = intervals[0];

		listOfIntervals.add(intervalPtr);

		for (int i = 1; i < intervals.length; i++) {
			if (intervalPtr[1] >= intervals[i][0]) {
				intervalPtr[1] = Math.max(intervalPtr[1], intervals[i][0]);
			} else {
				intervalPtr = intervals[i];
				listofIntervals.add(intervalPtr);
			}
		}

		return listOfIntervals.toArray(new int[listOfIntervals.size()][]);
	}
}

