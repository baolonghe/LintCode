package String;
import java.util.*;
public class Cont{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(count (n));
    }
    //分析：线性规划 f[n]=f[-100]+f[n-50]+f[n-20]+f[n-10]+f[n-5]+f[n-5]+f[n-1]
    private static long count(int n)
        {
          long[] f=new long[n+1];
        for(int i=0;i<5;i++)
            {f[i]=1;}
        for(int i=5;i<10;i++)
            {
        	//会+有重复9 5+4 8+1
            f[i]=f[i-5]+1;
        }
         for(int i=10;i<11;i++)
            {
            f[i]=f[i-10]+f[i-5]+1;
        }
        for(int i=20;i<50;i++)
            {
            f[i]=f[i-20]+f[i-10]+f[i-5]+1;
        }
          for(int i=50;i<100;i++)
            {
            f[i]=f[50]+f[i-20]+f[i-10]+f[i-5]+1;
        }
        for(int i=100;i<=n;i++)
        {
               f[i]=f[i-100]+f[i-50]+f[i-20]+f[i-10]+f[i-5]+1;
        }
        return f[n];
           
    }
}