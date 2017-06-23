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
        //��̬�滮 f[n]=f[i]&&{s[i+1,n��Ҳ�ǵ���}

        int maxLength = getMaxLength(dict);
        //��Ҫһ����ʼֵ������������ѭ����
        boolean[] canSegment = new boolean[s.length() + 1];
        //��ʼֵΪtrue 
        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            //�Ե��ʳ���Ϊ��λ������ǰ�����п��ܳ��ȵ��ַ����Ƿ�Ϊ����
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
