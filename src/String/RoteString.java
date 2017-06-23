package String;

public class RoteString {
  public static void roteString(char[] str,int offset)
  {
	  if (str==null||str.length==0) return;
	  reverse(str,0,str.length-offset-1);
	  reverse(str,str.length-offset,str.length-1);
	  reverse(str,0,str.length-1);
	  }
  private static void reverse(char[] str,int start,int end)
  {
	  for(int i=start,j=end;i<j;i++,j--)
	  {
		  char temp=str[i];
		  str[i]=str[j];
		  str[j]=temp;
	  }
  }
}
