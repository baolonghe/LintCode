package String;

import java.util.HashMap;

public class Solution6 {

    public boolean compareStrings(String A, String B) {
        
    	 int[] counts = new int[26];
         for (int i = 0; i < 26; i++) {
             counts[i] = 0;
         }
         for (int i = 0; i < A.length(); i++) {
             counts[A.charAt(i) - 'A'] ++;
         }
         for (int i = 0; i < B.length(); i++) {
             counts[B.charAt(i) - 'A'] --;
             if (counts[B.charAt(i) - 'A'] < 0) {
                 return false;
             }
         }
         return true;
    }
	
	public static void main(String[] args) {

	}

}
