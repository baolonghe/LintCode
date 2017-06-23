/**
 * 
 */
package String;

/**
 * @author Administrator
 *������Ӵ� ��̬�滮 dp[i][j]=dp[i+1][j-1]&&str[i]=str[j] i-j>1
 *���Ĵ����Ӵ� Ҳ�ǻ��Ĵ�
 */
public class Solution11 {
	
	public String longestPalindrome(String s){
		if (s==null||s.length()==0) return "";
		boolean[][] dp=new boolean[s.length()][s.length()];
		int maxlen=1;
		int start=0;
		for(int j=0;j<s.length();j++)
		{
			for(int i=0;i<=j;i++)
			{
				if (j-i<2){
					dp[i][j]=(s.charAt(i)==s.charAt(j));
				}else
				{
					dp[i][j]=dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
				}
				if (dp[i][j]&&(j-i+1)>maxlen)
					{
					    maxlen=j-i+1;
					    start=i;
					}
			}
		}
		return s.substring(start, maxlen);
		
	}

	
}
