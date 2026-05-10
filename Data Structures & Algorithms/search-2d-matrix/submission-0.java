class Solution {

    boolean binarySearch(int []nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = (high+low)/2;

            if(nums[mid] == target) return true;
            else if(nums[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i<n; i++){
            boolean res = binarySearch(matrix[i],target);

            if(res==true) return true;
        }
        return false;
    }
}
