package problemsolving.dynamicprogramming;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Definition for a binary tree node. */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

class PathSumSolution {
    int max=-2000;
    
    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null)
            return root.val;
        
        maxSum(root);
        
        return max;
    }
    
    public int maxSum(TreeNode root) {
        if (root == null) 
            return -2000;
        
        int L = maxSum(root.left);
        int R = maxSum(root.right);
        
        int leftOrRight = Math.max(L, R); // -2000
        int rootWithBranch = Math.max(L+root.val,R + root.val); // -1997
        int rootOrBranch = Math.max(rootWithBranch, L+R+root.val); // -1997
        rootOrBranch = Math.max(rootOrBranch, root.val); //3
        
        int nodeMaxVal = Math.max(leftOrRight, rootOrBranch); //-2000 , 3
        
        
        if (max < nodeMaxVal)
            max = nodeMaxVal; //3
        
        return (L == -2000 && R == -2000) ? root.val : Math.max(root.val, root.val + Math.max(L, R));
    }
}