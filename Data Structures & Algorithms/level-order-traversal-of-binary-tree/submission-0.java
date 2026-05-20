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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode>q = new LinkedList<>();

        q.add(root);
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>tmp = new ArrayList<>();
        if(root==null) return res;
        tmp.add(root.val);
        res.add(tmp);
        while(q.isEmpty()==false){
            int n = q.size();
            List<Integer>ls = new ArrayList<>();
            for(int i = 0; i<n; i++){
                TreeNode node = q.poll();
                if(node.left!=null){
                    q.add(node.left);
                    ls.add(node.left.val);
                }
                if(node.right!=null){
                    q.add(node.right);
                    ls.add(node.right.val);
                }

            }
            if(ls.size()==0) break;
            res.add(ls);
        }

        return res;
    }
}
