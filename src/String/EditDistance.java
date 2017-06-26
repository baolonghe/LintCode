/**
 * 
 */
package String;

/**
 * 给出两个单词word1和word2，计算出将word1 转换为word2的最少操作次数。

        你总共三种操作方法：

        插入一个字符
        删除一个字符
        替换一个字符
   分析：求最小用动态规划 f[i][j]表示已i-1和j-1结尾的最小距离
   f[i][j]=f[i-1][j-1] if (word1[i-1]==word2[j-1])
        or=1+mine{f[i-1][j],f[i][j-1],f[i-1][j-1]} (word1[i-1]!=word2[j-1])
 */
public class EditDistance {
  
      public int minDistance(String word1, String word2) {
    	  if (word1==null||word2==null)   	  return 0;
          int len1=word1.length();
          int len2=word2.length();
          int[][] f=new int[len1+1][len2+1];
          f[0][0]=0;//设置初始状态，也可以理解为字符串为空
          for(int i=1;i<=len1;i++)
          {
        	  for(int j=1;j<=len2;j++)
        	  {
        		  if (word1.charAt(i-1)==word2.charAt(j-1))
        			  f[i][j]=f[i-1][j-1];
        		  else
        			  f[i][j]=1+min(f[i-1][j],f[i][j-1],f[i-1][j-1]);
        	  }
          }
          return f[len1][len2];
          }
          private int min(int a,int b,int c)
          {
        	  int min1=Math.min(a, b);
        	  min1=Math.min(min1, c);
        	  return min1;
          }
          
    
 }
