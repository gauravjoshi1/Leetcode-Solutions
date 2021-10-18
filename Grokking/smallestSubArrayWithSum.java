// Optimized Sliding Window
class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    // TODO: Write your code here
    int sum = 0;
    int first = 0;
    int last = 0;
    int windowSize = 0;

    // Initial Window
    for (int i = 0; i < arr.length; i++) {
		if (sum < S) {
			sum = sum + arr[i];
			last = i;
			windowSize = windowSize + 1;
		} else {
			sum = sum - arr[start];
			start = start + 1;

			if (sum > S) {
				windowSize = last - start;
			}
		}
    }
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
