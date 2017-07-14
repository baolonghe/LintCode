package DepthSearch;

import java.util.ArrayList;
public class Solution {
   /**
     * ����git�������������ָ��
     *
     * @param matrix ���ھ��󣬱�ʾgit����matrix[i][j] == '1' ���ҽ���git���е�i���͵�j���ڵ������ӣ��ڵ�0Ϊgit���ĸ��ڵ�
     * @param indexA �ڵ�A��index
     * @param indexB �ڵ�B��index
     * @return ����
     */
    /**
     * ˼·���൱���������������ڵ����͹������ȣ�
     *
     * �����ο���ָoffer����50_���������ڵ����͹������ȣ��Ӹ��ڵ㿪ʼ��0�ڵ㣩ʹ����������洢·����
     * ʹ��visited[]����¼�ڵ����������ѷ��ʹ��Ľڵ㲻�ٷ��ʣ�
     * list:�洢�Ӹ��ڵ㵽��ǰ����·��
     * arrayList:�洢�Ӹ��ڵ㵽��ָ���������ڵ��·��
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
     * ǰ�����Ѱ��·����
     * ���ڵ�ǰ���ڱ����Ľڵ�i�����ýڵ��Ѿ����ʹ�����ֱ�ӷ��أ�
     * ���ýڵ�û�б����ʹ�������ʸýڵ㣨���ýڵ���ӵ�list�У�����visited[i]����Ϊtrue����
     *    ���ýڵ����ָ���Ľڵ㣬���ҵ�·��������ʱ��list��ӵ�arraylist�У�
     *    �����ݹ���ʸýڵ�i�������ӽڵ㣺
     *         ʹ��forѭ������matrix[i].charAt(k)==��1����˵���ڵ�i�ͽڵ�k�����ӣ��ݹ���ʽڵ�k;
     * ������֮����ݣ���list�е����һ���ڵ㵯����
     * @param matrix �� �ڵ���ڽӾ���
     * @param indexA ��ָ���ڵ�1
     * @param indexB �� ָ���ڵ�2
     * @param rows   �� �ܽڵ����
     * @param i      ����ǰ���ʽڵ�ı��
     * @param visited����¼�ڵ��Ƿ��ѱ�����
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