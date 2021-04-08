class Solution {
	public int[] search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return new int[] {-1, -1};
		
		int leftItem = searchLeft(nums, target);
		int rightItem = searchRight(nums, target);
		
		/* int leftItem = searchIndex(nums, target, false); 
		   int rightItem = searchIndex(nums, target, true);
		*/
		
		return new int[] {leftItem, rightItem};
	}

	private int searchLeft(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low)/2;
			
			if (nums[mid] == target) {
				if (mid == 0 || nums[mid] > nums[mid-1]) {
					return mid;
				}
				
				high = mid - 1;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
	
		return -1;
	}
	
	private int searchRight(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low)/2;
			
			if (nums[mid] == target) {
				if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
					return mid;
				}
				
				low = mid + 1;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid - 1;
			}
		}
		
		return -1;
	}
	
	private int searchIndex(int[] nums, int target, boolean upperBound) {
		int low = 0;
		int high = nums.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low)/2;
			
			if (nums[mid] == target) {
				if (upperBound) {
					if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
						return mid;
					}
					
					low = mid + 1;
				} else {
					if (mid == 0 || nums[mid] > nums[mid-1]) {
						return mid;
					}
					
					high = mid - 1;
				}
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}	
		}
		
		return -1;
	}
}