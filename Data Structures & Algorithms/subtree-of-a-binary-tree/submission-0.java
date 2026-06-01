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

    boolean isSame(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2 == null) return false;
        if(root1.val != root2.val) return false;

        return isSame(root1.left,root2.left) && isSame(root1.right,root2.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        boolean res = false;
        if(root.val == subRoot.val){
           res =  isSame(root,subRoot);
        }
        return res || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}
