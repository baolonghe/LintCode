/**
 * 
 */
package DepthSearch;
import java.util.*;
/**
 * 
 *
 */
public class SumOfKNumbers {
	public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
	       ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	        if(A==null||A.length==0) return res;
	        ArrayList<Integer> path=new ArrayList<Integer>();
	        Arrays.sort(A);
	        helper(A,k,target,0,path,res);
	        return res;
	        
	    }

	private void helper(int[] a, int k, int target, int start, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
		if (target==0&&path.size()==k)
		{
			res.add(new ArrayList<Integer>(path));
			return;
		}
		for(int i=start;i<a.length;i++)
		{
			if(target-a[i]>0) break;
			path.add(a[i]);
			helper(a,k,target-a[i],i+1,path,res);
			path.remove(path.size()-1);
		}
	}
	
}
