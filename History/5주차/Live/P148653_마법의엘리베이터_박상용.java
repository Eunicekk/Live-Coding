class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey != 0){
            if(storey % 10 <= 4){
                 answer += storey % 10;
                storey -= storey%10;
            }
            
            else if(storey % 10 >= 6){
                answer += 10 - storey % 10;
                storey += storey%10;
            }
            else {
                if((storey / 10)  % 10 >= 5){
                    answer += 10 - storey % 10;
                    storey += storey%10;
                }
                else{
                    answer += 10 - storey % 10;
                    storey -= storey%10;
                }
            }
            storey /= 10;
        }
        return answer;
    }
}

//정확성  테스트
//테스트 1 〉	통과 (0.01ms, 89.8MB)
//테스트 2 〉	통과 (0.01ms, 85.1MB)
//테스트 3 〉	통과 (0.01ms, 88.7MB)
//테스트 4 〉	통과 (0.02ms, 86.9MB)
//테스트 5 〉	통과 (0.02ms, 72.1MB)
//테스트 6 〉	통과 (0.01ms, 73.1MB)
//테스트 7 〉	통과 (0.02ms, 81.4MB)
//테스트 8 〉	통과 (0.01ms, 72.7MB)
//테스트 9 〉	통과 (0.02ms, 87.4MB)
//테스트 10 〉	통과 (0.02ms, 89.2MB)
//테스트 11 〉	통과 (0.01ms, 75.6MB)
//테스트 12 〉	통과 (0.01ms, 85.8MB)
//테스트 13 〉	통과 (0.01ms, 80.9MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0