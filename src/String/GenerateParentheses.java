/**
 * 
 */
package String;

import java.util.ArrayList;

/**生成括号 分析：遍历所有情况，过程中满足左括号要大于等于右括号
 * 
 *
 */
public class GenerateParentheses {

	public ArrayList<String> generateParentheses(int n){
		int right=n;
		int left=n;
		ArrayList<String> res= new ArrayList();
		String s="";
		helper(left,right,res,s);
		
		return res;
		
		}
	private void helper(int left,int right,ArrayList<String>res,String s)
	{
		if(left==0&&right==0) res.add(s);
		if (left<0||right<0||left<=right) return;
		helper(left-1,right,res,s+'(');
		helper(left,right-1,res,s+')');
		
	}
}
