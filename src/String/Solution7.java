package String;

public class Solution7 {

 
	public int longgestSubstring(String A,String B)
	{
		if (A==null||B==null||A.length()==0||B.length()==0) return 0;
		int lenA=A.length();
		int lenB=B.length();
		//f[i][j]=f[i-1][j-1]+1 or 0;设置一个初始状态f[0][0]=0;
		int[][] f=new int[lenA+1][lenB+1];
		for(int i=1;i<lenA;i++)
		{
			for(int j=1;j<lenB;j++)
			{
				if (A.charAt(i-1)==B.charAt(j-1))
				{
					f[i][j]=f[i-1][j-1]+1;
				}else
					f[i][j]=0;
			}
		}
		int max=f[1][1];
		for(int i=0;i<lenA;i++)
		{
			for(int j=1;j<=lenB;j++)
			{
				if (f[i][j]>max)
					max=f[i][j];
			}
		}
		return max;
	}

}
