/**
 * 
 */
package String;

/**
 * 最长无重复子字符串：求最优，用动态规划。
 * f[i]表示以i结尾的最长无重复子串的长度
 * f[i]=f[i-1]+1 or i-j
 *
 */
public class LonggestNorepeatingString {
 public int lengthOfSubString(String str)
 {
	 if (str==null||str.length()==0) return 0;
	 int[] f=new int[str.length()];
	 f[0]=1; 
	 int laststart=0;//上一次子串开始的位置
	 int maxlen=0;
	 for(int i=1;i<str.length();i++){
		 for(int j=i-1;j>=laststart;j--){
			 if (str.charAt(j)==str.charAt(i)){
				 laststart=j+1;
				 f[i]=i-j;				 
			 }else{
				 f[i]=f[i-1]+1;
			 }
		 }
		 maxlen=Math.max(maxlen,f[i]);
	 }
	 return maxlen;
 }
 }