package String;
import java.util.*;
public class Solution3 {
	public static void sortLetters(char [] chars){
	 if (chars==null||chars.length==0) return;
     int start=0;
     int end=chars.length;
     while(start<end){
    	 //找到第一个大写字母
    	 while(chars[start]>='a'&&start<=end){
    		 ++start;
    	 }
    	 //找到倒数的小谢字母
    	 while(chars[end]<='Z'&&end>=end){
    		 --end;
    	 }
    	 char temp=chars[start];
    	 chars[start]=chars[end];
    	 chars[end]=temp;
    	 
}
	}

}
