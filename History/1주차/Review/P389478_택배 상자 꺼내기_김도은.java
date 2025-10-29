class Solution {
    public int solution(int n, int w, int num) {
        
        int totalRow = n / w; //제일 높은 번쨰 줄 idx
        
        int row = (num - 1) / w; //0부터
        int col = 0; //칼럼
        
        int answer = 1;
        
        if(row % 2 == 0) {
            //짝수번째 줄 오른쪽으로 숫자 커짐
            col = (w-1) - num % w;
        } else {
            //홀수번째 줄 왼쪽으로 숫자 커짐
            col = num % w;
        }
        
        int check = num; //체크할 숫자
        
        for(int i = row + 1; i <= totalRow; i++) {
            
            if(i % 2 == 0) {
                check += col * 2 + 1;
            } else {
                check += (w - 1 - col) * 2 + 1;
            }
            
            if(check > n) break;
            
            answer++;
        }
        
        return answer;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.04ms, 84.2MB)
테스트 2 〉	통과 (0.02ms, 94.1MB)
테스트 3 〉	통과 (0.03ms, 73.5MB)
테스트 4 〉	통과 (0.02ms, 79.1MB)
테스트 5 〉	통과 (0.03ms, 79MB)
테스트 6 〉	실패 (0.02ms, 88.5MB)
테스트 7 〉	통과 (0.02ms, 79.3MB)
테스트 8 〉	통과 (0.02ms, 97.5MB)
테스트 9 〉	통과 (0.01ms, 88.9MB)
테스트 10 〉	실패 (0.02ms, 84.9MB)
테스트 11 〉	통과 (0.02ms, 85.3MB)
테스트 12 〉	통과 (0.02ms, 75.3MB)
테스트 13 〉	실패 (0.02ms, 76.9MB)
테스트 14 〉	통과 (0.03ms, 82.4MB)
테스트 15 〉	실패 (0.02ms, 84MB)
테스트 16 〉	통과 (0.02ms, 88.5MB)
테스트 17 〉	실패 (0.02ms, 81.2MB)
테스트 18 〉	통과 (0.02ms, 77MB)
테스트 19 〉	통과 (0.01ms, 72.9MB)
테스트 20 〉	실패 (0.03ms, 93MB)
테스트 21 〉	통과 (0.01ms, 72.3MB)
테스트 22 〉	통과 (0.02ms, 82.9MB)
테스트 23 〉	통과 (0.01ms, 87.6MB)
테스트 24 〉	실패 (0.01ms, 78.6MB)
테스트 25 〉	실패 (0.02ms, 80.9MB)
채점 결과
정확성: 10.0
합계: 10.0 / 100.0
*/
