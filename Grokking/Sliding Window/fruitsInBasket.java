class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    // TODO: Write your code here
    int start = 0;
    int maxLength = 0;
    HashMap<Character, Integer> fruitBasket = new HashMap<>();

    for (int end = 0; end < arr.length; end++) {
		fruitBasket.put(arr[end], fruitBasket.getOrDefault(arr[end], 0) + 1);

		while (fruitBasket.size() > 2) {
			fruitBasket.put(arr[start], fruitBasket.get(arr[start]) - 1);
			if (fruitBasket.get(arr[start]) == 0) {
				fruitBasket.remove(arr[start]);
			}

			start = start + 1;
		}

		maxLength = Math.max(maxLength, end - start + 1);
    }

    return maxLength;
  }
}
