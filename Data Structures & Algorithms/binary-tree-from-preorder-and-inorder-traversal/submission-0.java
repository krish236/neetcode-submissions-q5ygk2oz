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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer>mp = new HashMap<>();
        int n = preorder.length;
        for(int i = 0; i<preorder.length; i++){
            mp.put(inorder[i],i);
        }
        return build(preorder,inorder,0,n-1,0,n-1,mp);
    }

    TreeNode build(int []preorder, int []inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer,Integer>mp){
        if(preStart>preEnd || inStart>inEnd) return null;

        int rootInd = mp.get(preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);
        int numLeft = rootInd-inStart;

        TreeNode left = build(preorder,inorder,preStart+1,preStart+numLeft,inStart,rootInd-1,mp);
        TreeNode right = build(preorder,inorder,preStart+numLeft+1, preEnd, rootInd+1,inEnd,mp);

        root.left = left;
        root.right = right;

        return root;

        
    }
}
