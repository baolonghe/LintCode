package DepthSearch;

 class TreeNode {
	      public int val;
	      public TreeNode left, right;
	      public TreeNode(int val) {
	          this.val = val;
	          this.left = this.right = null;
	      }
	  }
public class FlattenBinaryTreeToList {
	public void flattenBinaryTreeToList(TreeNode root){
		helper(root);
		
	}
	private static void helper(TreeNode root){
		if (root==null) return;
		helper(root.left);
		helper(root.right);
		TreeNode temp=root.right;
		root.right=root.left;
		if (root.right!=null)
		{  
			root=root.right;
		   root.right=temp;
		}
	}
	
}
