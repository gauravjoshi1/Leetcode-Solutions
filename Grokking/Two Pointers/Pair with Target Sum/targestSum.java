class PairWithTargetSum {

  public static int[] search(int[] arr, int targetSum) {
    // TODO: Write your code here
    int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int currSum = arr[start] + arr[end];

			if (currSum > targetSum) {
				end = end - 1;
			} else if (currSum < targetSum) {
				start = start + 1;
			} else {
				return new int[]{start, end};
			}
		}

		return new int[]{-1, -1};
  }
}
