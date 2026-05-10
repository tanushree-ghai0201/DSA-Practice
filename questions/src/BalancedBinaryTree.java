import utils.*;
public class BalancedBinaryTree {
    private boolean ans = true;
    private int checkRecur(TreeNode root) {
        if(root == null)
            return 0;
        int left = checkRecur(root.left);
        int right = checkRecur(root.right);
        if(Math.abs(left - right) > 1)
            ans = false;
        return 1 + Math.max(left, right);
        
    }
    public boolean isBalanced(TreeNode root) {
        checkRecur(root);
        return ans;
    }
}
