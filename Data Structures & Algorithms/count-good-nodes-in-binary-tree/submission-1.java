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

    void solve(TreeNode root, int []count, int maxi){
        if(root==null) return;

        if(root.val>=maxi){
            System.out.println(root.val);
            maxi = root.val;
            count[0]++;
        }

        solve(root.left,count,maxi);
        solve(root.right,count,maxi);
    }
    public int goodNodes(TreeNode root) {
        int []count = new int[1];
        int maxi = -1000;
        solve(root,count,maxi);

        return count[0];
    }
}
