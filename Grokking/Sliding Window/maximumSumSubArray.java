class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    // TODO: Write your code here
    int n = arr.length;
    int maxVal = 0;
    int count = 0;
	int start = 0;
	int end = 0;

	for (end = 0; end < n; end++) {
		count = count + arr[end];

		if (end > k - 1) {
			count = count - arr[start];
			maxVal = Math.max(maxVal, count);
			start = start + 1;
		}
	}

	return maxVal;
  }
}
