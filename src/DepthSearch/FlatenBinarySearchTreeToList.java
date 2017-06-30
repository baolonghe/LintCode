package DepthSearch;

public class FlatenBinarySearchTreeToList {
public void flattenBianrySearchTreeToList(TreeNode root)
{
	//不能用DFS因为必须先处理最后的
	if (root==null) return;
	//二叉搜索树 从小到大 即是中序遍历
	}
private static TreeNode ConvertNode(TreeNode root,TreeNode lastNode)
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
