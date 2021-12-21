class PairWithTargetSum {

  public static int[] search(int[] arr, int targetSum) {
    // TODO: Write your code here
    int start = 0;
		int end = arr.length - 1;
		int[] resultArr = new int[2];
		while (start <= end) {
			int currSum = arr[start] + arr[end];

			if (currSum > targetSum) {
				end = end - 1;
			} else if (currSum < targetSum) {
				start = start + 1;
			} else {
				resultArr[0] = start;
				resultArr[1] = end;

				return resultArr;
			}
		}

		return resultArr;
  }
}
