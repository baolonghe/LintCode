package String;
import java.util.*;
public class Solution5 {
 public int autoi(String str)
 {
	 if (str==null) return 0;
	 str.trim();
	 int sign=1;
	 int index=0;
	 //首先判断首位
	 if(str.charAt(index)=='+') index++;
	 else if(str.charAt(index)=='-')
	 {
		 sign=-1;
		 index++ ;
     }
	 else return 0;
	 long num=0;
	 for (;index<str.length();index++)
	 {
		 if(str.charAt(index)<0||str.charAt(index)>9)
			break;
		 num=num*10+(str.charAt(index)-'0');
	 }
	 if (num*sign>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
	 if(num*sign<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
	 return (int) (num*sign);
  }
}
