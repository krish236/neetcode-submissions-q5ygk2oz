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

    boolean check(TreeNode root, int mini, int maxi){
        if(root==null) return true;

        if(root.val<=mini || root.val>=maxi){
            return false;
        }

        return check(root.left,mini,root.val) && check(root.right,root.val,maxi);
    }
    public boolean isValidBST(TreeNode root) {
        int mini = (int)-1e9;
        int maxi = (int)1e9;

        return check(root,mini,maxi);
    }
}
