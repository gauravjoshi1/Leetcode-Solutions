/***************************************************************

nums = [3, 4, 2]
output = 6. delete max 4 & 2

nums = [2, 2, 3, 3, 3, 4]
output = 9 delete 3 3 times. 4 and 2 get deleted by default


Approach: Create an array upto "max value" starting from 0.
 
For the example, [2, 2, 3, 3, 3, 4] our sample array is
[0  1  2  3  4]. 

Store the frequency sum for this array for each index.
Thus our array == [0  0  4  9  4]

Use this to fill the skip/choose like in house robber problem.


	skip 			choose
0	0				0
1	0				0
2	0				4
3	4				9
4	9				8

Answer: 9

***************************************************************/

class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        int skip = 0;
        int choose = 0;
        
        for (int val : nums) {
        	if (maxVal < val) {
        		maxVal = val;
        	}
        }
        
        int[] earningMatrix = new int[maxVal + 1];
        
        
        for (int i = 0; i < nums.length; i++) {
        	earningMatrix[nums[i]] += nums[i];
        }
        
        for (int i = 1; i < maxVal + 1; i++) {
        	int temp = skip;
        	skip = Math.max(skip, choose);
        	choose = earningMatrix[i] + temp;
        }
        
        return Math.max(skip, choose);
    }
}