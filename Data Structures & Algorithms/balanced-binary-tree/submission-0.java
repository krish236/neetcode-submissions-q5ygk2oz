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
    boolean flag = true;
    int height(TreeNode root){
        if(root==null) return 0;

        int lefth = height(root.left);
        int righth = height(root.right);

        if(Math.abs(lefth-righth)>1){
            flag = false;
        }

        return 1 + Math.max(lefth,righth);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int h = height(root);

        return flag;
        
    }
}
