package DepthSearch;

class TreeNode2{
	public int val;
	public TreeNode2 left;
	public TreeNode2 right;
}

public class FlatenBinarySearchTreeToList {
public void flattenBianrySearchTreeToList(TreeNode2 root)
{
	//������DFS��Ϊ�����ȴ�������
	if (root==null) return;
	//���������� ��С���� �����������
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
     if (root.right!=null)//��if���� �������ٴη���null
     {
         lastNode=ConvertNode(root.right, lastNode);  
     }
     return lastNode;  
}
	

}
