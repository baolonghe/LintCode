/**
 * 
 */
package String;
import java.util.*;
/**
 * 条件：每一段数字必须大于等于0，小于等于255，
 *动态规划：遍历每一个状态 深度优先搜索
 */
public class RestoreIpAddress {
  public ArrayList<String> restoreIpAddress(String str)
  {
	 if (str==null||str.length()<4||str.length()>12) 
	  return null;
	 ArrayList<String> res=new ArrayList<String>();
	 ArrayList<String> list=new ArrayList<String>();
	 helper(res,list,str, 0);
	 return res;
	 
  }
  private static void helper(ArrayList<String> res,ArrayList<String> list,String str,int start)
  {
	  if (list.size()==4)
	  {
		  if(start!=str.length())
			  return;
		  StringBuilder sb=new StringBuilder();
		  for(String word:list)
		  {
			  sb.append(word);
			  sb.append('.');
		  }
		  sb.deleteCharAt(sb.length()-1);
		  res.add(sb.toString());
	  } 
	  for(int i=start;i<str.length()&&i<start+3;i++)
	  {
		  String temp=str.substring(start,start+i);
		  if (isValid(temp)) 
		  {
			  list.add(temp);
			  helper(res,list,str,start+i);
			  list.remove(list.size()-1);
		  }
	  }
	  
  }
  private static boolean isValid(String str){
	  if (str.charAt(0)=='0')
			  return str.equals('0');
	  if(Integer.valueOf(str)>0&&Integer.valueOf(str)<256)
		  return true;
	  return false;
  }
}

