/*************************************************************
In the optimal solution, use three pointers to keep a track of three things.

1. First pointer to keep a track of value 0.
2. Last pointer to keep a track of value 2.
3. Current pointer to check all the elements of the array

We utilize these three pointers to build the following algorithm:

- Iterate the array from :
    → index == first pointer == current pointer == 0 to last pointer == last element in the array

- When current value is 0:
    → Swap the current value with the first pointer.
    → Update the first pointer and the current pointer to the right

- When current value is 1:
    → Move the current pointer to the right

- When the current value is 2:
    →  Swap the current value and last pointer
    →  Move the last pointer to the left.


Time Complexity: O(n)
Space Complexity: O(1)

**********************************************************/

class Solution {
    public void sortColors(int[] nums) {
        int curr = 0;
        int first = 0;
        int last = nums.length - 1;

        while (curr < last) {
            int swap = nums[curr];

            if (nums[curr] == 0) {
                nums[curr] = nums[first];
                nums[first] = swap;
                first++;
                curr++
            } else if (nums[curr] == 2) {
                nums[curr] = nums[last];
                nums[last] = swap;
                last--;
            }

            else curr++;
        }
    }
}
