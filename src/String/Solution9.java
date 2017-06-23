package String;
import java.util.*;
public class Solution9 {

    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        //动态规划 f[n]=f[i]&&{s[i+1,n）也是单词}

        int maxLength = getMaxLength(dict);
        //需要一个初始值，来满足整套循环。
        boolean[] canSegment = new boolean[s.length() + 1];
        //初始值为true 
        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            //以单词长度为单位，遍历前面所有可能长度的字符，是否为单词
            for (int lastWordLength = 1;
                     lastWordLength <= maxLength && lastWordLength <= i;
                     lastWordLength++) {
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (dict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }
        return canSegment[s.length()];
     }
    
    
}
