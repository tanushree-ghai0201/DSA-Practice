import utils.*;
public class LCA {
        public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;
        if(root.val == p.val || root.val == q.val)
            return root;
        if((root.val > p.val && root.val < q.val) || ( root.val < p.val && root.val > q.val))
            return root;
        if(root.val > p.val && root.val > q.val)
            return findLCA(root.left, p, q);
        return findLCA(root.right, p, q);       
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCA(root,p,q);
    }
}