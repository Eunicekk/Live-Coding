import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        int length = score.length;
        int[] box = new int[m];
        int count = 0;
        
        for (int i = length - 1; i >= 0; i--) {
            box[count] = score[i];
            count++;
            
            if (count == m) {
                answer += (box[count-1] * m);
                count = 0;
            }
        }
        
        return answer;
    }
}
