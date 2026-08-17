import utils.*;
 public class SubTreeOfAnotherTree {
    
    boolean ans = false;
    private boolean check(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null)
            return true;
        if((root == null && subRoot != null) || (root != null && subRoot == null))
            return false;
        if(root.val != subRoot.val)
            return false;
        return check(root.left, subRoot.left) && check(root.right, subRoot.right);

    }
    private void helper(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return;
        helper(root.left, subRoot);
        ans = ans || check(root,subRoot);
        helper(root.right, subRoot);    
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        helper(root, subRoot);
        return ans;
    }

}
