package String;

public class Kmp {
	
	    public static int kmp(String str, String sub) {
	        if(str == null || sub == null || str.length() == 0 || sub.length() == 0){
	            throw new IllegalArgumentException("str或者sub不能为空");
	        }

	        int j = 0;
	        int[] n = next(sub);
	        System.out.println("n[0]="+n[0]);
	        for (int i = 0; i < str.length(); i++) {
	            while(j > 0 && str.charAt(i) != sub.charAt(j)){
	                j = n[j - 1];
	            }

	            if(str.charAt(i) == sub.charAt(j)){
	                j++;
	            }

	            if(sub.length() == j){
	                int index = i - j + 1;
	                return index;
	            }
	        }

	        return -1;
	    }

	    /**
	     * 用于生成部分匹配表
	     * @param sub
	     * @return
	     *类似动态规划 f[i]=f[i-1]+1 || 
	     *
	     **/
	    private static int[] next(String sub) {
	        int[] n = new int[sub.length()];
	        int x = 0;
	        for (int i = 1; i < sub.length(); i++) {
	            while (x > 0 && sub.charAt(i) != sub.charAt(x)) {
	                x = n[x - 1];
	            }

	            if (sub.charAt(i) == sub.charAt(x)) {
	                x++;
	            }

	            n[i] = x;
	        }
	        return n;
	    }
	   
	 public static void main(String[] args) {
	     String str = "BBC ABCDAB ABCDABCDABDE";
         String sub = "ABCDAB";
         int index = kmp(str, sub); 
         System.out.println("index-->"+index);
    }
	
}
