package String;
import java.util.*;
//AÖÐÊÇ·ñ°üº¬B×Ö·û´®
public class Solution2 {
  public int strStr(String str1,String str2){
	  if(str1==null||str1==null) return -1;
	  int N=str1.length();
	  int M=str1.length();
	  for(int i=0;i<N;i++){
		  int j;
		  for(j=0;j<M;j++){
			  if(str1.charAt(i+j)!=str2.charAt(j)) break;
		  }
		  if(j==M) return i;
	  }
	  return -1;
  }
}
