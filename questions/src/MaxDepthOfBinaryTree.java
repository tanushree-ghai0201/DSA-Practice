import utils.*;
public class MaxDepthOfBinaryTree {
    private int recursiveDepthCalculator(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(recursiveDepthCalculator(root.left), recursiveDepthCalculator(root.right));
    }
    public int maxDepth(TreeNode root) {
        return recursiveDepthCalculator(root);
    }
}
