package DepthSearch;

import java.util.ArrayList;
public class Solution {
   /**
     * 返回git树上两点的最近分割点
     *
     * @param matrix 接邻矩阵，表示git树，matrix[i][j] == '1' 当且仅当git树中第i个和第j个节点有连接，节点0为git树的跟节点
     * @param indexA 节点A的index
     * @param indexB 节点B的index
     * @return 整型
     */
    /**
     * 思路：相当于求多叉树中两个节点的最低公共祖先；
     *
     * 方法参考剑指offer中题50_树中两个节点的最低公共祖先，从根节点开始（0节点）使用先序遍历存储路径，
     * 使用visited[]来记录节点访问情况，已访问过的节点不再访问，
     * list:存储从根节点到当前结点的路径
     * arrayList:存储从根节点到所指定的两个节点的路径
     *
     */
    static ArrayList<ArrayList<Integer>> arraylist = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();
    public static int getSplitNode(String[] matrix, int indexA, int indexB) {
 
        if (matrix == null) {
            return -1;
        }
        if (indexA == 0 || indexB == 0 ) {
            return 0;
        }
        if (indexA == indexB) {
            return indexA;
        }
        int rows =matrix.length;
        boolean [] visited = new boolean[rows];
        arraylist.clear();
        list.clear();
        beforeOrder2(matrix, indexA, indexB, rows, 0,  visited);
        ArrayList<Integer> list1 = arraylist.get(0);
        ArrayList<Integer> list2 = arraylist.get(1);
        if (list1.get(0) != list2.get(0)) {
            return -1;
        }      
        
        searchList(list1,list2);
         
         
    }
    private static int searchList(ArrayList<Integer> list1,ArrayList<Integer> list2)
    {
    	 int i = 0;
         while (i < list1.size() && i < list2.size() && list1.get(i) == list2.get(i)) {
             i++;       
         }      
         if (i < list1.size() && i < list2.size()) {
             return list1.get(i - 1);
         }
          
         return i == list1.size() ? list1.get(i - 1) : list2.get(i - 1 );
    }
    /**
     * 前序遍历寻找路径：
     * 对于当前正在遍历的节点i，若该节点已经访问过，则直接返回，
     * 若该节点没有被访问过，则访问该节点（将该节点添加到list中，并将visited[i]设置为true），
     *    若该节点等于指定的节点，则找到路径，将此时的list添加到arraylist中，
     *    继续递归访问该节点i的所有子节点：
     *         使用for循环，若matrix[i].charAt(k)==‘1’，说明节点i和节点k有连接，递归访问节点k;
     * 访问完之后回溯，将list中的最后一个节点弹出；
     * @param matrix ： 节点的邻接矩阵
     * @param indexA ：指定节点1
     * @param indexB ： 指定节点2
     * @param rows   ： 总节点个数
     * @param i      ：当前访问节点的编号
     * @param visited：记录节点是否已被访问
     */
    public static void beforeOrder2(String[] matrix, int indexA, int indexB ,int rows,int i , boolean [] visited) {
        if (visited[i]) {
            return;
        }      
        list.add(i);
        visited[i] = true;
        if (i == indexA ) {
            arraylist.add(new ArrayList<>(list));
        }
        if (i == indexB ) {
            arraylist.add(new ArrayList<>(list));
        }      
        if (arraylist.size() == 2) {
            return;
        }
        for (int k = 0; k < rows; k++) {
            if (matrix[i].charAt(k) == '1') {
                beforeOrder2(matrix, indexA, indexB, rows, k, visited);
            }
             
        }
        list.remove(list.size() - 1);
     
        return;
    }
}