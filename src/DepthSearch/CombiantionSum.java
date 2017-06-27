package DepthSearch;
//数字组合
import java.util.*;
public class CombiantionSum {
  public ArrayList<ArrayList<Integer>> combinationSum(int[] nums,int target)
  {
	  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	  ArrayList<Integer> path=new ArrayList<Integer>();
	  if (nums==null||nums.length==0) return res;
	  Arrays.sort(nums);
	  helper(nums,target,0,path,res);
	return res;
  }
  private static void helper(int[] nums,int target,int start,ArrayList<Integer> path,
		                     ArrayList<ArrayList<Integer>> res){
	  if(target==0)
	      res.add(new ArrayList<Integer>(path));
	 // if(target<0){这种方式不好 无法利用到数组的排序特性
	//      return;
		  for(int i=start;i<nums.length;i++)
			{
			  if (i!=0&&nums[i]==nums[i-1]) continue;
			  if(target<nums[i]) break;
		      path.add(nums[i]);	
			  helper(nums,target-nums[i],i+1,path,res);
			  path.remove(path.remove(path.size()-1));
			}
		  
	  }
	   
  }