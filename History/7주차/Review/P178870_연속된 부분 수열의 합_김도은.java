import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int min = 1000000; //최대길이
        
        int[] answer = new int[2];
        
        while(end < sequence.length) {
            if(sum < k) {
                end++;
                if(end < sequence.length) sum += sequence[end];
            } else {
                if(sum == k) {
                    if ((end - start) < min) {
                        min = end - start;
                        answer[0] = start;
                        answer[1] = end;
                    }
                }
                
                sum -= sequence[start++];
            }
        }
        
        return answer;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.02ms, 80.3MB)
테스트 2 〉	통과 (0.02ms, 80.8MB)
테스트 3 〉	통과 (0.02ms, 85.8MB)
테스트 4 〉	통과 (0.05ms, 84.1MB)
테스트 5 〉	통과 (0.77ms, 74.3MB)
테스트 6 〉	통과 (1.12ms, 83.2MB)
테스트 7 〉	통과 (1.95ms, 93.4MB)
테스트 8 〉	통과 (2.75ms, 84.9MB)
테스트 9 〉	통과 (5.01ms, 101MB)
테스트 10 〉	통과 (7.17ms, 114MB)
테스트 11 〉	통과 (10.48ms, 139MB)
테스트 12 〉	통과 (8.14ms, 135MB)
테스트 13 〉	통과 (11.35ms, 142MB)
테스트 14 〉	통과 (9.02ms, 125MB)
테스트 15 〉	통과 (8.61ms, 140MB)
테스트 16 〉	통과 (4.97ms, 125MB)
테스트 17 〉	통과 (7.73ms, 139MB)
테스트 18 〉	통과 (0.02ms, 81.4MB)
테스트 19 〉	통과 (0.02ms, 86MB)
테스트 20 〉	통과 (0.02ms, 74.9MB)
테스트 21 〉	통과 (0.02ms, 87.4MB)
테스트 22 〉	통과 (0.02ms, 72.8MB)
테스트 23 〉	통과 (0.02ms, 81.5MB)
테스트 24 〉	통과 (9.21ms, 145MB)
테스트 25 〉	통과 (5.22ms, 139MB)
테스트 26 〉	통과 (7.04ms, 126MB)
테스트 27 〉	통과 (6.60ms, 121MB)
테스트 28 〉	통과 (9.59ms, 120MB)
테스트 29 〉	통과 (9.16ms, 126MB)
테스트 30 〉	통과 (9.77ms, 142MB)
테스트 31 〉	통과 (0.02ms, 72.9MB)
테스트 32 〉	통과 (0.03ms, 96.8MB)
테스트 33 〉	통과 (0.03ms, 72.3MB)
테스트 34 〉	통과 (0.02ms, 72.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
