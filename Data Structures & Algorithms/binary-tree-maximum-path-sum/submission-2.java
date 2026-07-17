/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    int helper(TreeNode root, int []arr){
        if(root==null) return 0;
        
        int left = helper(root.left,arr);
        if(left<0) left = 0;
        int right = helper(root.right,arr);

        if(right<0) right = 0;
        arr[0] = Math.max(arr[0],root.val+left+right);
        int maxi = Math.max(left,right);
        maxi+=root.val;

        return maxi;

    }
    public int maxPathSum(TreeNode root) {
        int []arr = new int[1];
        arr[0] = (int) (-1e9);

        int height = helper(root,arr);
        return arr[0];
    }
}
