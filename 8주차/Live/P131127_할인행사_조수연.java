import java.util.*;

/**
  테스트 1 〉	통과 (15.28ms, 110MB)
  테스트 2 〉	통과 (58.95ms, 105MB)
  테스트 3 〉	통과 (12.50ms, 105MB)
  테스트 4 〉	통과 (45.74ms, 127MB)
  테스트 5 〉	통과 (43.97ms, 102MB)
  테스트 6 〉	통과 (7.43ms, 78.6MB)
  테스트 7 〉	통과 (30.60ms, 103MB)
  테스트 8 〉	통과 (63.70ms, 128MB)
  테스트 9 〉	통과 (16.12ms, 111MB)
  테스트 10 〉	통과 (63.72ms, 119MB)
  테스트 11 〉	통과 (10.15ms, 90.4MB)
  테스트 12 〉	통과 (0.07ms, 85.3MB)
*/

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> ori = new HashMap<>();
        Map<String, Integer> window = new HashMap<>();
        for(int i=0;i<want.length;i++) {
            ori.put(want[i], number[i]);

        }
        
        for(int i=0;i<10;i++) {
            window.put(discount[i], window.getOrDefault(discount[i], 0)+1);            
        }

        boolean aa = true;
        for(String key : ori.keySet()) {
            if(window.getOrDefault(key, 0) < ori.get(key)) aa= false;
        }
        
        if(aa) answer++;
        
        f : for(int i=10;i<discount.length;i++) {
            
            window.put(discount[i-10], window.get(discount[i-10])-1);
            if(window.get(discount[i-10]) == 0) window.remove(discount[i-10]);
            
            window.put(discount[i], window.getOrDefault(discount[i], 0)+1);
            
            for(String key : ori.keySet()) {
                if(window.getOrDefault(key, 0) < ori.get(key)) continue f;
            }
            answer++;
        }
        
        return answer;
    }
}
