package String;
import java.util.*;


public class Solution4 {
    public static void main(String[] args){
    	String s = "he bao long";
    	String res=reverseWords(s);
    	System.out.println(res);
    	
    }
	public static String reverseWords(String s)
		{
			String[] words=s.trim().split(" +");
			Collections.reverse(Arrays.asList(words));
			return String.join(" ",words);

		}
	    
	}


