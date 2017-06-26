/**
 * 
 */
package String;

/**
 * @author hbh
 *¿Õ¸ñÌæ»»
 *
 */
public class SpaceReplacement {
 public int spaceReplacement(char[] str)
 {
	 if (str==null||str.length==0) return 0;
	 int num=0;
	 for(int i=0;i<str.length;i++)
	 {
		 if(str[i]==' ');
		 num++;
	 }
	 char[] newarray=new char[str.length+num];
	 int j=num*2+str.length;
	 for(int i=str.length-1;i>=0;i--)
	 {
		 if (newarray[i]!='r')
			 newarray[j--]=str[i];
		 if (newarray[i]==' '){
			 newarray[j--]='2';
			 newarray[j--]='0';
			 newarray[j--]='%';
		 }
	 }
	return 0;
	 
 }
}
