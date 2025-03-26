import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(tangerine);
        
        int count = 1;
        int target = tangerine[0];
        
        for (int i = 1; i < tangerine.length; i++) {
            if (target == tangerine[i]) {
                count++;
            } else {
                pq.offer(count);
                target = tangerine[i];
                count = 1;
            }
        }
        
        pq.offer(count);
        
        while (k > 0) {
            k -= pq.poll();
            answer++;
        }
        
        return answer;
    }
}
