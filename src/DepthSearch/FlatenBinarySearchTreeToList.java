package DepthSearch;

class TreeNode2{
	public int val;
	public TreeNode2 left;
	public TreeNode2 right;
}

public class FlatenBinarySearchTreeToList {
public void flattenBianrySearchTreeToList(TreeNode2 root)
{
	//不能用DFS因为必须先处理最后的
	if (root==null) return;
	//二叉搜索树 从小到大 即是中序遍历
	}
private static TreeNode2 ConvertNode(TreeNode2 root,TreeNode2 lastNode)
{
	 if (root== null) {  
         return null;  
     }  
    if(root.left!=null)
	 lastNode=ConvertNode(root.left, lastNode);  
   
     root.left = lastNode;  
     if (lastNode != null) {  
         lastNode.right = root;  
     }  
     lastNode = root;    
     if (root.right!=null)//加if避免 右子树再次返回null
     {
         lastNode=ConvertNode(root.right, lastNode);  
     }
     return lastNode;  
}
	

}
