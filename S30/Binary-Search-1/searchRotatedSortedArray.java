class Solution {
   public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
        	int mid = low + (high - low)/2;
        	
        	if (nums[mid] == target) {
        		return mid;
        	}
        	
        	
        	if (nums[low] <= nums[mid]) {
                /* target lies between sorted left half of arr*/
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
        	} else {
        		/* target lies between sorted right half of arr*/
        		if (nums[mid] < target && target <= nums[high]) {
        			low = mid + 1;
        		} else {
        			high = mid - 1;
        		}
        	}
        }
        
        return -1;
    }
}