/**
 * 
 */
package DepthSearch;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 *
 */
class TreeNode1 {  
    int val;  
    ArrayList<TreeNode1> children = new ArrayList<>();  
    
    public TreeNode1(int val) {  
        this.val = val;  
    }  
   
    @Override  
    public String toString() {  
        return val + "";  
    }  
}  
public class lastCommonParent {

	/* 
     * ��ȡ�����ڵ����͹������� 
     */  
	private static  boolean found=false;
    public static TreeNode1 getLastCommonParent(TreeNode1 root, TreeNode1 p1, TreeNode1 p2) {  
        //path1��path2�ֱ�洢���ڵ㵽p1��p2��·����������p1��p2��  
    	ArrayList<TreeNode1> path1 = new ArrayList<TreeNode1>();  
    	ArrayList<TreeNode1> path2 = new ArrayList<TreeNode1>();  
    	ArrayList<TreeNode1> tmpList = new ArrayList<TreeNode1>();  
  
        getNodePath(root, p1, tmpList, path1);  
        getNodePath(root, p2, tmpList, path2);  
        //���·�������ڣ����ؿ�  
        if (path1.size() == 0 || path2.size() == 0)  
            return null;  
  
        return getLastCommonParent(path1, path2);  
    }  
  
    // ��ȡ���ڵ㵽Ŀ��ڵ��·��  
    public static void getNodePath(TreeNode1 root, TreeNode1 target, ArrayList<TreeNode1> tmpList, ArrayList<TreeNode1> path) {  
        //³����  
    	//Ӧ����һ��ȫ�ֱ�������ʶ�Ƿ����ҵ� ���м�֦����
        if (root == null || root == target)  
            return;  
        tmpList.add(root);  
        ArrayList<TreeNode1> children = root.children;  
        for (TreeNode1 node : children) {  
            if (node == target) {
            	
                path.addAll(tmpList);  
                break;  
            }  
            getNodePath(node, target, tmpList, path);  
        }  
  
        tmpList.remove(tmpList.size() - 1);  //������ȻҪ����������״���������ֹ
    }  
    //������ת��Ϊ���������һ����ͬ�ڵ�  
    private static TreeNode1 getLastCommonParent(ArrayList<TreeNode1> p1, ArrayList<TreeNode1> p2) {  
        TreeNode1 tmpNode = null;  
        for (int i = 0; i < p1.size(); i++) {  
            if (p1.get(i) != p2.get(i))  
                break;  
            tmpNode = p1.get(i);  
        }  
  
        return tmpNode;  
    }  
    
    public static void main(String[] args) {  
        test01();  
        System.out.println("==========");  
        test02();  
        System.out.println("==========");  
        test03();  
    }  
      
    // ��״��ͨ����  
    //             1  
    //           /   \  
    //         2      3  
    //        /         \  
    //      4            5  
    //     / \        /  |  \  
    //    6   7      8   9  10  
    public static void test01() {  
        TreeNode1 n1 = new TreeNode1(1);  
        TreeNode1 n2 = new TreeNode1(2);  
        TreeNode1 n3 = new TreeNode1(3);  
        TreeNode1 n4 = new TreeNode1(4);  
        TreeNode1 n5 = new TreeNode1(5);  
        TreeNode1 n6 = new TreeNode1(6);  
        TreeNode1 n7 = new TreeNode1(7);  
        TreeNode1 n8 = new TreeNode1(8);  
        TreeNode1 n9 = new TreeNode1(9);  
        TreeNode1 n10 = new TreeNode1(10);  
  
        n1.children.add(n2);  
        n1.children.add(n3);  
  
        n2.children.add(n4);  
  
        n4.children.add(n6);  
        n4.children.add(n7);  
  
        n3.children.add(n5);  
  
        n5.children.add(n8);  
        n5.children.add(n9);  
        n5.children.add(n10);  
  
        System.out.println(getLastCommonParent(n1, n9, n10));  
    }  
  
    // ���˻���һ������  
    //               1  
    //              /  
    //             2  
    //            /  
    //           3  
    //          /  
    //         4  
    //        /  
    //       5  
    private static void test02() {  
        TreeNode1 n1 = new TreeNode1(1);  
        TreeNode1 n2 = new TreeNode1(2);  
        TreeNode1 n3 = new TreeNode1(3);  
        TreeNode1 n4 = new TreeNode1(4);  
        TreeNode1 n5 = new TreeNode1(5);  
  
        n1.children.add(n2);  
        n2.children.add(n3);  
        n3.children.add(n4);  
        n4.children.add(n5);  
  
        System.out.println(getLastCommonParent(n1, n4, n5));  
    }  
  
    // ���˻���һ������һ����㲻������  
    //               1  
    //              /  
    //             2  
    //            /  
    //           3  
    //          /  
    //         4  
    //        /  
    //       5  
    private static void test03() {  
        TreeNode1 n1 = new TreeNode1(1);  
        TreeNode1 n2 = new TreeNode1(2);  
        TreeNode1 n3 = new TreeNode1(3);  
        TreeNode1 n4 = new TreeNode1(4);  
        TreeNode1 n5 = new TreeNode1(5);  
        TreeNode1 n6 = new TreeNode1(6);  
  
        n1.children.add(n2);  
        n2.children.add(n3);  
        n3.children.add(n4);  
        n4.children.add(n5);  
  
        System.out.println(getLastCommonParent(n1, n5, n6));  
    }  
}
