import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        if(ingredient.length < 4) {
            return 0;
        }

        for(int i=0;i<ingredient.length;i++) {
            sb.append(Integer.toString(ingredient[i]));
            int l = sb.length();
            if(l >= 4 && sb.substring(l-4).equals("1231")) {
                sb.delete(l-4, l);
                answer++;
            }
        }
        
        
        return answer;
    }
}
