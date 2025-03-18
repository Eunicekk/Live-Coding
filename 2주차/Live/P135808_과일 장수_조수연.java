import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<score.length;i++) {
            pq.offer(score[i]);
        }
        
        int cnt = 0; // m개를 담았는지 체크하는 용도
        while(!pq.isEmpty()) {
            cnt++;
            int tar = pq.poll();
            
            if(cnt == m) { // m개를 담았을 때
                cnt = 0;
                answer += m * tar;
            }
        }
        
        return answer;
    }
}
