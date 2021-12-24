class SortedArraySquares {
	public static int[] makeSquares(int[] arr) {
		int[] squares = new int[arr.length];
		int start = 0;
		int end = arr.length - 1;
		int squareIndx = arr.length - 1;

		while (start <= end) {
			int startSquare = arr[start] * arr[start];
			int endSquare = arr[end] * arr[end];

			if (startSquare > endSquare) {
				squares[squareIndx--] = startSquare;
				start = start + 1;
			} else {
				squares[squareIndx--] = endSquare;
				end = end - 1;
			}
		}

		return squares;
	}

}
