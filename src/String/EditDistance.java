/**
 * 
 */
package String;

/**
 * ������������word1��word2���������word1 ת��Ϊword2�����ٲ���������

        ���ܹ����ֲ���������

        ����һ���ַ�
        ɾ��һ���ַ�
        �滻һ���ַ�
   ����������С�ö�̬�滮 f[i][j]��ʾ��i-1��j-1��β����С����
   f[i][j]=f[i-1][j-1] if (word1[i-1]==word2[j-1])
        or=1+mine{f[i-1][j],f[i][j-1],f[i-1][j-1]} (word1[i-1]!=word2[j-1])
 */
public class EditDistance {
  
      public int minDistance(String word1, String word2) {
    	  if (word1==null||word2==null)   	  return 0;
          int len1=word1.length();
          int len2=word2.length();
          int[][] f=new int[len1+1][len2+1];
          f[0][0]=0;//���ó�ʼ״̬��Ҳ�������Ϊ�ַ���Ϊ��
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
