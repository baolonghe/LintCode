/**
 * 
 */
package DepthSearch; 
import java.util.*;
 
/**
 *·Ö¸î»ØÎÄ´®
 *
 */
public class Palindrome {
	public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (s == null) {
            return res;
        }

        ArrayList<String> path = new ArrayList<String>();
        helper(s, path, 0,res);

        return res;
    }
	private void helper(String s, ArrayList<String> path, int start, 
			ArrayList<ArrayList<String>> res) {
		if (start==s.length()){
			res.add(new ArrayList<String> (path));
		}
		for(int i=start+1;i<=s.length();i++)
		{
			if(!isValid(s.substring(start,i))) continue;
                path.add(s.substring(start,i));
				helper(s,path,i+1,res);
				path.remove(path.size());
	    }
    }
	private boolean isValid(String s){
		int start=0;
		int end=s.length()-1;
		while(start<end)
			{
			if (s.charAt(start)!=s.charAt(end)){
				return false;
			}
			start++;
			end++;
		    }
		return true;
		
	}
	
}
