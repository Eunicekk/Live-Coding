import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int count = 0;
        int zeroCnt = 0;
        
        int N = lottos.length;
        
        for(int i = 0; i < N; i++) {
            int num = lottos[i];
            
            if(num == 0) {
                zeroCnt++;
                continue;
            }
            
            for(int j = 0; j < N; j++) {
                if(num == win_nums[j]) {
                    count++; // 맞춘 개수
                    break;
                }
            }
        }
        
        int max = count == 0 && zeroCnt == 0 ? 6 : 6 - (zeroCnt + count) + 1; //최고등수
        int min = count == 0 ? 6 : 6 - count + 1;
        
        return new int[]{max, min};
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.01ms, 88.2MB)
테스트 2 〉	통과 (0.01ms, 75.9MB)
테스트 3 〉	통과 (0.01ms, 75MB)
테스트 4 〉	통과 (0.02ms, 85.1MB)
테스트 5 〉	통과 (0.01ms, 81.9MB)
테스트 6 〉	통과 (0.02ms, 88.1MB)
테스트 7 〉	통과 (0.01ms, 69.9MB)
테스트 8 〉	통과 (0.01ms, 89MB)
테스트 9 〉	통과 (0.01ms, 77.2MB)
테스트 10 〉	통과 (0.01ms, 91.4MB)
테스트 11 〉	통과 (0.02ms, 88.5MB)
테스트 12 〉	통과 (0.02ms, 84.9MB)
테스트 13 〉	통과 (0.01ms, 72.5MB)
테스트 14 〉	통과 (0.01ms, 78MB)
테스트 15 〉	통과 (0.01ms, 92.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
