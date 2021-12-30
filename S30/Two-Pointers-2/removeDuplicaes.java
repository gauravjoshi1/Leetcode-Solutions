class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int ptr = 0;
        int numLen = 0;

        for (int i = 1; i < nums.length; i++) {
            // duplicate not detected
            if (nums[ptr] != nums[i]) {
                nums[numLen] = nums[ptr];
                numLen = numLen + 1;
                ptr = i;
            }
        }

        nums[numLen] = nums[ptr];
        return numLen + 1;
    }
}
