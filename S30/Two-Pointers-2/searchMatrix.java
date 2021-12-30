class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0) return false;
        
        int rPtr = 0;    
        int row = matrix.length;
        int col = matrix[0].length;
        boolean flag = false;
        
        while (rPtr < row) {
            // possible range detected
            if (matrix[rPtr][0] <= target && matrix[rPtr][col - 1] >= target) {
                flag = binarySearchMatrix(matrix, target, rPtr);
                
                if (flag) return flag;
            }
            
            rPtr = rPtr + 1;
        }
        
        return flag;
    }
    
    private boolean binarySearchMatrix(int[][] matrix, int target, int r) {
        int low = 0;
        int high = matrix[0].length - 1;
        
        while (low <= high) {
            int mid = low + (high - low)/2;
            
            if (matrix[r][mid] == target) return true;
            else if (matrix[r][mid] < target) low = low + 1;
            else high = high - 1;
        }
        
        return false;
    }
}