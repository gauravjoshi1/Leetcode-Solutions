class RemoveDuplicates {
	public static int remove(int[] arr) {
		if (arr == null || arr.length == 0) return -1;

		int start = 0;
		int end = start + 1;
		int finalLen = 0;

		while (end < arr.length) {
			if (arr[start] != arr[end]) {
				finalLen = finalLen + 1;
				start = end;
				end = end + 1;
			} else {
				end = end + 1;
			}
		}

		return finalLen + 1;
	}
}
