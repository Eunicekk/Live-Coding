import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] book_time) {
        int len = book_time.length;
        
        int[][] bookTime = new int[len][2];
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < 2; j++) {
                String[] tmp = book_time[i][j].split(":");
                int hour = Integer.parseInt(tmp[0])*60;
                int min = Integer.parseInt(tmp[1]);
                
                bookTime[i][j] = hour + min;
            }
        }
        
        Arrays.sort(bookTime, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < len; i++) {
            int start = bookTime[i][0];
            int end = bookTime[i][1];
            
            if(!pq.isEmpty() && pq.peek() + 10 <= start) {
                pq.poll();
            }
            
            pq.offer(end);
        }
       
        
        return pq.size();
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.99ms, 89MB)
테스트 2 〉	통과 (2.74ms, 72MB)
테스트 3 〉	통과 (8.17ms, 90.8MB)
테스트 4 〉	통과 (4.06ms, 88.2MB)
테스트 5 〉	통과 (1.34ms, 86.7MB)
테스트 6 〉	통과 (6.64ms, 95.9MB)
테스트 7 〉	통과 (6.91ms, 77.7MB)
테스트 8 〉	통과 (3.64ms, 92MB)
테스트 9 〉	통과 (3.85ms, 87.1MB)
테스트 10 〉	통과 (4.96ms, 87.3MB)
테스트 11 〉	통과 (7.18ms, 100MB)
테스트 12 〉	통과 (8.26ms, 90.1MB)
테스트 13 〉	통과 (2.68ms, 72MB)
테스트 14 〉	통과 (6.89ms, 92.6MB)
테스트 15 〉	통과 (5.84ms, 79.1MB)
테스트 16 〉	통과 (3.59ms, 93.3MB)
테스트 17 〉	통과 (6.31ms, 88.5MB)
테스트 18 〉	통과 (4.97ms, 85.5MB)
테스트 19 〉	통과 (5.96ms, 83.6MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
