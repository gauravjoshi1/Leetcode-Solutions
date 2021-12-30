class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2 ,0, nums1, 0, n);
            return;
        }
        
        if (n == 0) {
            return;
        }
        
        int n1_ptr = m - 1;
        int n2_ptr = n - 1;
        int backPtr = m + n - 1;
    
        while (backPtr >= 0) {    
            if (n1_ptr < 0 || n2_ptr < 0) break;
            
            if (nums1[n1_ptr] >= nums2[n2_ptr]) {
                nums1[backPtr] = nums1[n1_ptr];
                nums1[n1_ptr] = Integer.MAX_VALUE;
                n1_ptr = n1_ptr - 1;
            } else {
                nums1[backPtr] = nums2[n2_ptr];
                n2_ptr = n2_ptr - 1;
            }
            
            backPtr = backPtr - 1;
        }
        
        while (backPtr >= 0) {
            if (n1_ptr < 0 && n2_ptr >= 0) {
                nums1[backPtr] = nums2[n2_ptr];
                n2_ptr = n2_ptr - 1;
            } else if (n1_ptr >= 0 && n2_ptr < 0) {
                nums1[backPtr] = nums1[n1_ptr];
                n1_ptr -= 1;
            }
            
            backPtr -= 1;
        }
        
    }
}