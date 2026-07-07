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
    int res = 0;
    void traverse(TreeNode root, int k, int []count){
        if(root==null) return;
        traverse(root.left,k,count);
        count[0]++;
        if(count[0]==k){
            res = root.val;
            return;
        }
        traverse(root.right,k,count);
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;

        int []count = new int[1];
        
        traverse(root,k,count);

        return res;
    }
}
