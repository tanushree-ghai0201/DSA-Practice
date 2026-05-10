import utils.*;
public class DiameterOfBinaryTree {
        private int ans = 0 ;
    private int diameterCalculator(TreeNode root) {
        if(root == null)
            return 0;
        int leftSide = diameterCalculator(root.left);
        int rightSide = diameterCalculator(root.right);
        int ht = 1 + Math.max(leftSide, rightSide);
        int curr = leftSide + rightSide;
        ans = Math.max(ans, curr);
        return ht;  
        }
    public int diameterOfBinaryTree(TreeNode root) {
        diameterCalculator(root);
        return ans;
    }
}
