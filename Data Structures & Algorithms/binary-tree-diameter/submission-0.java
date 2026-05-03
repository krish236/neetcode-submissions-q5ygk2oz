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

    
    int getHeight(TreeNode root, int[]diameter){
        if(root==null) return 0;

        int lefth = getHeight(root.left,diameter);
        int righth = getHeight(root.right,diameter);

        diameter[0] = Math.max(diameter[0],lefth+righth);

        return 1 + Math.max(lefth,righth);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;     
        int[]diameter = new int[1];
        diameter[0] = 0;
        int h = getHeight(root,diameter);

        System.out.println(h);

        return diameter[0];
    }
}
