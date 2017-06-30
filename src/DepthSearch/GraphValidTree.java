package DepthSearch;
import java.util.*;

public class GraphValidTree {
	  private  static int count=0;
	   private static boolean isTree=false;
	  
	       public boolean validTree(int n, int[][] edges) {
		        // Write your code here
		        //图是树的充要条件：图图是连通的且图有n个节点，n-1条边。
		        //图是连通的条件是：至少n-1条bian,且每个节点之间是相通的。
		        //在一个无向图 G 中，若从顶点vi到顶点vj有路径相连（当然从vj到vi也一定有路径），则称vi和vj是连通的
		        //总结：连通图是树的条件：n个定点，n-1条边。各个节点之间相通。
		        //分析：判断是否有n-1条边，判断是否有环(是否连通)
			  
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