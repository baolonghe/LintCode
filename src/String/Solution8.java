package String;
import java.util.*;
public class Solution8 {
//最长公共前缀 逐个字字母比较
	public String longgestCommonPrefix(String[] strs)
	{
		 if (strs==null||strs.length==0) return "";
	        if (strs.length==1) return strs[0];
	        int min=Integer.MAX_VALUE;
			for(int i=0;i<strs.length;i++)
			{
				if (strs[i].length()<min)
				{
					min=strs[i].length();
				}
			}
			String common=new String();
			for(int i=0;i<min;i++)
			{
				int norm=strs[0].charAt(i);
				for(int j=0;j<strs.length;j++)
				{
					if (strs[j].charAt(i)!=norm)
					{
						common=strs[0].substring(0,i);
						return common;
					}
					
				}
				common=strs[0].substring(0,min);
				
			}
			return common;
	}
	
	//逐个单词比较
	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            while( j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if( j == 0) {
                return "";
	}
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

}
