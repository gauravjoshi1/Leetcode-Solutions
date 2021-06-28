/**************************************************************************

### Brute-Force Approach

- Represent the numbers in the array as a Set.
- Check if all the numbers from 1 to n are present in the set.
- Return the missing numbers from the Set.

Time Complexity: O(n)

Space Complexity: O(n) We store all the elements of the array in the set.

***************************************************************************/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
		HashSet<Integer> numSet = new HashSet<>();
		ArrayList<Integer> disappearingNums = new ArrayList<>();

		// add all the numbers from nums to numSet
		for (int val : nums) {
			numSet.add(val);
		}

		for (int i = 1; i < nums.length; i++) {
			if (!numSet.contains(i)) {
				disappearingNums.add(i);
			}
		}

		return disappearingNums;
    }
}

/***************************************************************************
### Optimal Solution:

Maintain a 1 : 1 correspondence between the number and values present at index - 1
where index = number.

Time Complexity: O(n)
Space Complexity: O(1)

***************************************************************************/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();

        // change the magnitude of items in arr that are -ve
        for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]);
			nums[index - 1] = nums[index - 1] < 0 ? nums[index - 1] : nums[index - 1] * -1;
        }

        for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				arr.add(i + 1);
			}
        }

        return arr;
    }
}
