package DepthSearch;

public class FlatenBinarySearchTreeToList {
public void flattenBianrySearchTreeToList(TreeNode root)
{
	//������DFS��Ϊ�����ȴ�������
	if (root==null) return;
	//���������� ��С���� �����������
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
     if (root.right!=null)//��if���� �������ٴη���null
     {
         lastNode=ConvertNode(root.right, lastNode);  
     }
     return lastNode;  
}
	

}
