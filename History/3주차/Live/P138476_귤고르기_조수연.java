import java.util.*;

class Solution {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(tangerine);
        int cnt = 1; int target귤 = tangerine[0];
        for(int i=1;i<tangerine.length;i++) {
            if(target귤 == tangerine[i]) {
                cnt++; continue;
            } else {
                pq.offer(cnt);
                target귤 = tangerine[i];
                cnt = 1;
            }
        }
        pq.offer(cnt);
        
        int num = 0;
        
        if(k == tangerine.length) return pq.size();
        else num = tangerine.length - k;
        
        int nowNum = 0;
        while(!pq.isEmpty()) {
            int n = pq.peek();
            nowNum += n;
            if(num < nowNum) return pq.size();
            else pq.poll();
        }
        
        
        
        
        return answer;
    }
}
