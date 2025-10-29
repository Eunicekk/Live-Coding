class Solution {
    public int solution(int storey) {
        
        int answer = 0;
        
        while(storey > 0) {
            int end = storey % 10; //마지막 자리수
            storey /= 10;
            
            if(end == 5) {
                int nextEnd = storey % 10;
                
                if(nextEnd >= 5) {
                    answer += 10 - end;
                    storey++; //1자리수 올림
                } else {
                    answer += end;
                }
            } else if(end > 5) {
                answer += 10 - end;
                storey++; //1자리수 올림
            } else {
                answer += end;
            }
        }
        
        return answer;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.01ms, 88.1MB)
테스트 2 〉	통과 (0.01ms, 75.4MB)
테스트 3 〉	통과 (0.01ms, 92.6MB)
테스트 4 〉	통과 (0.02ms, 73.6MB)
테스트 5 〉	통과 (0.01ms, 82.5MB)
테스트 6 〉	통과 (0.01ms, 77.9MB)
테스트 7 〉	통과 (0.01ms, 80MB)
테스트 8 〉	통과 (0.01ms, 96.1MB)
테스트 9 〉	통과 (0.01ms, 82.2MB)
테스트 10 〉	통과 (0.02ms, 73.3MB)
테스트 11 〉	통과 (0.01ms, 71.8MB)
테스트 12 〉	통과 (0.03ms, 83.7MB)
테스트 13 〉	통과 (0.01ms, 81.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
