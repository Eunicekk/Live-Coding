import java.util.*;

class Solution {
    static int count;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    
    public List solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        int[][] arr = new int[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length;i++){
            for(int j = 0; j < maps[0].length();j++){
                if(maps[i].charAt(j) == 'X'){
                      arr[i][j] = 0;
                }else
                arr[i][j]= maps[i].charAt(j)-'0';
            }
        }
        for(int i = 0; i < maps.length;i++){
            for(int j = 0; j < maps[0].length();j++){
                if(arr[i][j] >= 1){
                    count = 0;
                  dfs(i,j,maps.length,maps[0].length(),arr);
                    answer.add(count);
                }
            }
        }
        
        Collections.sort(answer);
        if(answer.size() == 0 )
            answer.add(-1);
        
        
        
        return answer;
    }
    
     void dfs(int r, int c, int maxr, int maxc,int[][] arr){
         if(r < 0 || c < 0 || r >= maxr || c >= maxc){
            return;
         }
         if(arr[r][c] == 0)
             return;
         else{
            count += arr[r][c];
             arr[r][c] = 0;
         }
         
         for(int d = 0; d < 4 ; d++){
            dfs(r+dr[d],c+dc[d],maxr, maxc, arr);
         }
        return;
     } 
}

//정확성  테스트
//테스트 1 〉	통과 (0.05ms, 77.9MB)
//테스트 2 〉	통과 (0.07ms, 73.9MB)
//테스트 3 〉	통과 (0.07ms, 89.6MB)
//테스트 4 〉	통과 (0.11ms, 83.2MB)
//테스트 5 〉	통과 (0.45ms, 75.3MB)
//테스트 6 〉	통과 (0.60ms, 75.6MB)
//테스트 7 〉	통과 (0.40ms, 76MB)
//테스트 8 〉	통과 (1.32ms, 81.5MB)
//테스트 9 〉	통과 (1.06ms, 76MB)
//테스트 10 〉	통과 (1.26ms, 88.3MB)
//테스트 11 〉	통과 (1.03ms, 90.7MB)
//테스트 12 〉	통과 (1.63ms, 75.7MB)
//테스트 13 〉	통과 (1.50ms, 81MB)
//테스트 14 〉	통과 (4.21ms, 78.3MB)
//테스트 15 〉	통과 (2.23ms, 82.8MB)
//테스트 16 〉	통과 (2.25ms, 75.9MB)
//테스트 17 〉	통과 (0.30ms, 76.6MB)
//테스트 18 〉	통과 (3.44ms, 91.4MB)
//테스트 19 〉	통과 (3.54ms, 72.1MB)
//테스트 20 〉	통과 (1.49ms, 83.9MB)
//테스트 21 〉	통과 (0.52ms, 79.9MB)
//테스트 22 〉	통과 (0.10ms, 85.2MB)
//테스트 23 〉	통과 (5.78ms, 99.3MB)
//테스트 24 〉	통과 (4.56ms, 85.2MB)
//테스트 25 〉	통과 (0.18ms, 80.1MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0