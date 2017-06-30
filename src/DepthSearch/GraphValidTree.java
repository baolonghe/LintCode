package DepthSearch;
import java.util.*;

public class GraphValidTree {
	  private  static int count=0;
	   private static boolean isTree=false;
	  
	       public boolean validTree(int n, int[][] edges) {
		        // Write your code here
		        //ͼ�����ĳ�Ҫ������ͼͼ����ͨ����ͼ��n���ڵ㣬n-1���ߡ�
		        //ͼ����ͨ�������ǣ�����n-1��bian,��ÿ���ڵ�֮������ͨ�ġ�
		        //��һ������ͼ G �У����Ӷ���vi������vj��·����������Ȼ��vj��viҲһ����·���������vi��vj����ͨ��
		        //�ܽ᣺��ͨͼ������������n�����㣬n-1���ߡ������ڵ�֮����ͨ��
		        //�������ж��Ƿ���n-1���ߣ��ж��Ƿ��л�(�Ƿ���ͨ)
			  
			  if (edges==null||edges.length!=n-1) return false;
			  boolean [] visited=new boolean[n];
	          Map<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
	          map=transformToMap(edges,n);
	          int start=0;
			  helper(n,start,visited,map);
			  return count==n;
		        
		    }
		  private void helper(int n, int start, boolean[] visited, Map<Integer,ArrayList<Integer>> map) {
			    visited[start]=true;
		         count++;
			 for(int  adjacent:map.get(start))
			 {
				 if (visited[adjacent]==false)
				 {
					 helper(n,adjacent,visited,map);
				 }
			 }
			
		}
		private Map<Integer,ArrayList<Integer>> transformToMap(int[][] edges,int n)
		  {
			  Map<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
			  ArrayList<Integer> path=new ArrayList<Integer>();
			for(int i=0;i<n;i++)
			{   
				map.put(i, new ArrayList<Integer>());
			}
			for(int i=0;i<edges.length;i++)
			{
				int v=edges[i][0];
				int u=edges[i][1];
				map.get(v).add(u);
				map.get(u).add(v);
			}
			return map;
		  }
}