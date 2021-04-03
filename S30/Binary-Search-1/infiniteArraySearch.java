public Solution {
	
	public int search(int nums[], int target) {
		if (nums == null) {
			return -1;
		}
	
		int low = 0;
		int high = 1;
		
		while (target > nums[high]) {
			low = high;
			high = high * 2;
		}
		
		// reach the range where the target lies
		return binarySearch(low, high, target, nums);
	}
	
	
	public int binarySearch(int low, int high, int target, int[] nums) {
		while (low <= high) {
			int mid = low + (high - low)/2;
			
			if (nums[mid] == target) {
				return mid;
			}
			
			if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return -1;
	}
}