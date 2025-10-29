import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int[] count = new int[k+1];
        for(int i = 0; i < score.length;i++){
            count[score[i]]++;
        }
        int index = k;
        int applecount = m;
        while(true){
            if(count[index] > applecount){
                count[index] -= applecount;
                    answer += m*index;
                applecount = m;
            }else{
                applecount -= count[index];
                 count[index] = 0;
                  if(applecount == 0 ){
                          answer += m*index;
                      applecount = m;
                }
                index--;
            }
            
            if(index <= 0){
                break;
            }
        }
        return answer;
    }
}

// 테스트 1 〉	통과 (0.02ms, 89.2MB)
// 테스트 2 〉	통과 (0.02ms, 74.7MB)
// 테스트 3 〉	통과 (0.02ms, 78.7MB)
// 테스트 4 〉	통과 (0.02ms, 87.7MB)
// 테스트 5 〉	통과 (0.01ms, 70.1MB)
// 테스트 6 〉	통과 (2.00ms, 92.1MB)
// 테스트 7 〉	통과 (2.36ms, 87.9MB)
// 테스트 8 〉	통과 (0.25ms, 74.5MB)
// 테스트 9 〉	통과 (1.41ms, 79MB)
// 테스트 10 〉	통과 (1.37ms, 75.7MB)
// 테스트 11 〉	통과 (6.12ms, 125MB)
// 테스트 12 〉	통과 (6.20ms, 123MB)
// 테스트 13 〉	통과 (7.88ms, 121MB)
// 테스트 14 〉	통과 (5.56ms, 133MB)
// 테스트 15 〉	통과 (6.45ms, 139MB)
// 테스트 16 〉	통과 (0.01ms, 72.4MB)
// 테스트 17 〉	통과 (0.02ms, 72.8MB)
// 테스트 18 〉	통과 (0.02ms, 85MB)
// 테스트 19 〉	통과 (0.01ms, 76.8MB)
// 테스트 20 〉	통과 (0.02ms, 83.8MB)
// 테스트 21 〉	통과 (0.02ms, 78.5MB)
// 테스트 22 〉	통과 (0.02ms, 88.3MB)
// 테스트 23 〉	통과 (0.02ms, 79MB)
// 테스트 24 〉	통과 (0.01ms, 72.7MB)
// 채점 결과
// 정확성: 100.0
// 합계: 100.0 / 100.0