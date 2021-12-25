import java.util.*;

class TripletSumToZero {

	public static List<List<Integer>> searchTriplets(int[] arr) {
		List<List<Integer>> triplets = new ArrayList<>();
		// TODO: Write your code here
		if (arr == null || arr.length == 0) return triplets;

		Arrays.sort(arr);
		int i = 0;

		while (i < arr.length && arr[i] <= 0) {
			if (i == 0 || arr[i] != arr[i - 1]) {
				tripletCalc(arr, i, triplets);
			}

			i = i + 1;
		}

		return triplets;
	}

	private static void tripletCalc(int[] nums, int i, List<List<Integer>> res) {
		int low = i + 1;
		int high = nums.length - 1;

		while (low < high) {
			int sum = nums[low] + nums[high] + nums[i];

			if (sum > 0) {
				high = high - 1;
			} else if (sum < 0) {
				low = low + 1;
			} else {
				res.add(Arrays.asList(nums[i], nums[low], nums[high]));
				low = low + 1;

				while (low < high && nums[low] == nums[low - 1]) {
					low = low + 1;
				}
			}
		}
	}
}
