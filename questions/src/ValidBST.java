import utils.*;
class ValidBST {
    private boolean check(TreeNode root, long l, long r ){
        if(root == null)
            return true;
        if(root.val <= l || root.val >= r)
            return false;
        return check(root.left, l, root.val) && check(root.right, root.val, r);
    }
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}