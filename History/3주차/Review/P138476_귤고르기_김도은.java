import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int len = tangerine.length;
        
        for(int i = 0; i < len; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        
        
        int cnt = 0;
        
        for(int i = 0; i < list.size(); i++) {
            k -= list.get(i);
            cnt ++;
            
            if(k <= 0) break;
        }

        return cnt;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (30.15ms, 88.1MB)
테스트 2 〉	통과 (24.06ms, 88.3MB)
테스트 3 〉	통과 (29.79ms, 89MB)
테스트 4 〉	통과 (45.35ms, 84.4MB)
테스트 5 〉	통과 (20.69ms, 86.2MB)
테스트 6 〉	통과 (23.22ms, 82.5MB)
테스트 7 〉	통과 (24.47ms, 81.4MB)
테스트 8 〉	통과 (56.14ms, 88MB)
테스트 9 〉	통과 (23.46ms, 84.1MB)
테스트 10 〉	통과 (24.26ms, 89MB)
테스트 11 〉	통과 (0.48ms, 86.9MB)
테스트 12 〉	통과 (0.29ms, 88.8MB)
테스트 13 〉	통과 (0.25ms, 87.8MB)
테스트 14 〉	통과 (0.22ms, 96.8MB)
테스트 15 〉	통과 (0.22ms, 87.3MB)
테스트 16 〉	통과 (0.27ms, 75MB)
테스트 17 〉	통과 (0.22ms, 75.7MB)
테스트 18 〉	통과 (0.25ms, 73.3MB)
테스트 19 〉	통과 (0.30ms, 76MB)
테스트 20 〉	통과 (0.22ms, 84.4MB)
테스트 21 〉	통과 (1.40ms, 75.7MB)
테스트 22 〉	통과 (1.41ms, 74.4MB)
테스트 23 〉	통과 (1.59ms, 78.6MB)
테스트 24 〉	통과 (1.56ms, 86.8MB)
테스트 25 〉	통과 (19.54ms, 83MB)
테스트 26 〉	통과 (12.43ms, 91MB)
테스트 27 〉	통과 (65.58ms, 107MB)
테스트 28 〉	통과 (39.57ms, 96.3MB)
테스트 29 〉	통과 (84.11ms, 89.5MB)
테스트 30 〉	통과 (58.36ms, 94.5MB)
테스트 31 〉	통과 (17.81ms, 93.2MB)
테스트 32 〉	통과 (26.48ms, 101MB)
테스트 33 〉	통과 (44.55ms, 95.4MB)
테스트 34 〉	통과 (42.73ms, 111MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
