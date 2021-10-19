// Optimized Sliding Window
class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    // TODO: Write your code here
    int sum = 0;
    int first = 0;
    int last = 0;
    int windowSize = Integer.MAX_VALUE;

	for (int end = 0; end < arr.length; end++) {
		sum = sum + arr[end];
		while (sum >= S) {
			windowSize = Math.min(windowSize,  end - start + 1);
			sum = sum - arr[start];
			start = start + 1;
		}
    }
    return windowSize;
  }
}

// Brute Force Approach
class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    // TODO: Write your code here
    int sum = 0;
    int subArrLen = Integer.MAX_VALUE;
    int start = 0;
    int end = 0;
    int n = arr.length;

    for (start = 0; start < n; start++) {
		sum = arr[start];
		if (sum >= S) {
			subArrLen = Math.min(subArrLen, 1);
		}

		for (end = start + 1; end < n; end++) {
			sum = sum + arr[end];
			if (sum >= S) {
				subArrLen = Math.min(subArrLen, end - start + 1);
				break;
			}
		}
    }

    return subArrLen == Integer.MAX_VALUE ? 0 : subArrLen;
  }
}
