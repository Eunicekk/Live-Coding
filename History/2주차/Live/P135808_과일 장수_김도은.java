class Solution {
    public int solution(int k, int m, int[] score) {
        
        int[] appleCnt = new int[k+1]; //사과는 최대 k점
        int total = score.length; //총 사과 개수
        int box = total / m; //박스 개수
        
        for(int i = 0; i < total; i++) {
            appleCnt[score[i]]++;
        }
        
        int sum = 0;
        int idx = k;
        
        for(int i = 0; i < box; i++) {
            int cnt = 0;
            int min = k;
            
            while(true) {
                if(cnt == m) break;
                
                if(appleCnt[idx] == 0) {
                    idx--;
                    continue;
                }               
                
                cnt++;
                appleCnt[idx]--;
                min = Math.min(min, idx);
            }
            sum += min * m;
        }

        return sum;
    }
}

/*
테스트 1 〉	통과 (0.05ms, 90.5MB)
테스트 2 〉	통과 (0.05ms, 88.4MB)
테스트 3 〉	통과 (0.05ms, 83MB)
테스트 4 〉	통과 (0.04ms, 77.5MB)
테스트 5 〉	통과 (0.04ms, 72.6MB)
테스트 6 〉	통과 (3.42ms, 81.8MB)
테스트 7 〉	통과 (3.35ms, 92.4MB)
테스트 8 〉	통과 (0.66ms, 89MB)
테스트 9 〉	통과 (3.30ms, 88.8MB)
테스트 10 〉	통과 (2.13ms, 97MB)
테스트 11 〉	통과 (14.28ms, 138MB)
테스트 12 〉	통과 (12.51ms, 132MB)
테스트 13 〉	통과 (11.77ms, 121MB)
테스트 14 〉	통과 (13.47ms, 127MB)
테스트 15 〉	통과 (13.77ms, 123MB)
테스트 16 〉	통과 (0.03ms, 92.1MB)
테스트 17 〉	통과 (0.03ms, 73.5MB)
테스트 18 〉	통과 (0.05ms, 76MB)
테스트 19 〉	통과 (0.03ms, 105MB)
테스트 20 〉	통과 (0.03ms, 72MB)
테스트 21 〉	통과 (0.04ms, 90.5MB)
테스트 22 〉	통과 (0.03ms, 88.3MB)
테스트 23 〉	통과 (0.04ms, 87MB)
테스트 24 〉	통과 (0.03ms, 81.7MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
