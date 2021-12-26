import java.util.*;

class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int target) {
    // TODO: Write your code here
    if (arr == null || arr.length == 0) return -1;
    Arrays.sort(arr);

    int res = -1;
    int prevD = Integer.MAX_VALUE;
    int low, high;

    for (int i = 0; i < arr.length; i++) {
		low = i + 1;
		high = arr.length - 1;

		while (low < high) {
			int currSum = arr[i] + arr[low] + arr[high];
			int distFromT = Math.abs(currSum - target);

			if (distFromT < prevD || distFromT == prevD && currSum < res) {
				prevD = distFromT;
				res = currSum;
			}

			if (currSum > target) {
				high = high - 1;
			} else {
				low = low + 1;
			}
		}
    }

    return res;
  }

}
