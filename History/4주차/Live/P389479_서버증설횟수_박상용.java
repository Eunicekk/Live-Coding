class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] check = new int[players.length];
        for(int i = 0; i < players.length; i++){
            int tmp = (players[i] - check[i]*m)/m;
            if(tmp > 0){
                answer += tmp;
                for(int j = 0; j < k; j++){
                    if(i+j < players.length){
                        check[i+j] += tmp;
                    }
                }
            }
        }
        return answer;
    }
}

//정확성  테스트
//테스트 1 〉	통과 (0.02ms, 74.2MB)
//테스트 2 〉	통과 (0.01ms, 81.1MB)
//테스트 3 〉	통과 (0.02ms, 90.8MB)
//테스트 4 〉	통과 (0.02ms, 84.3MB)
//테스트 5 〉	통과 (0.02ms, 90.2MB)
//테스트 6 〉	통과 (0.01ms, 88.4MB)
//테스트 7 〉	통과 (0.03ms, 88.2MB)
//테스트 8 〉	통과 (0.02ms, 80.2MB)
//테스트 9 〉	통과 (0.02ms, 76.5MB)
//테스트 10 〉	통과 (0.02ms, 77.4MB)
//테스트 11 〉	통과 (0.01ms, 75.1MB)
//테스트 12 〉	통과 (0.01ms, 80.8MB)
//테스트 13 〉	통과 (0.02ms, 75MB)
//테스트 14 〉	통과 (0.01ms, 76.6MB)
//테스트 15 〉	통과 (0.01ms, 73.4MB)
//테스트 16 〉	통과 (0.01ms, 77.9MB)
//테스트 17 〉	통과 (0.01ms, 92.1MB)
//테스트 18 〉	통과 (0.02ms, 74.1MB)
//테스트 19 〉	통과 (0.02ms, 75.9MB)
//테스트 20 〉	통과 (0.02ms, 86.2MB)
//테스트 21 〉	통과 (0.02ms, 86.3MB)
//테스트 22 〉	통과 (0.02ms, 82.5MB)
//테스트 23 〉	통과 (0.02ms, 76.9MB)
//테스트 24 〉	통과 (0.03ms, 74.5MB)
//테스트 25 〉	통과 (0.02ms, 90MB)
//테스트 26 〉	통과 (0.01ms, 88.5MB)
//테스트 27 〉	통과 (0.02ms, 91MB)
//테스트 28 〉	통과 (0.02ms, 86.5MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0