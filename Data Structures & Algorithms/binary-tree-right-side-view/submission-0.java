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

    void preOrder(TreeNode root, int []vis, List<Integer>ls){
        if(root==null) return;

        if(vis[0]==ls.size()){
            ls.add(root.val);
        }

        System.out.println(root.val);
        vis[0]++;
        preOrder(root.right,vis,ls);

        preOrder(root.left,vis,ls);
        vis[0]--;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ls = new ArrayList<>();
        int []vis = new int[1];
        vis[0] = 0;
        preOrder(root,vis,ls);

        return ls;
    }
}
