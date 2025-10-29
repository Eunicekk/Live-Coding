import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        boolean[][][] check = new boolean[100][100][9999];
        boolean[][][] check2 = new boolean[100][100][9999];
        for(int i= 0; i < routes.length; i++){
            int r1 = points[routes[i][0]-1][0]-1;
            int c1 = points[routes[i][0]-1][1]-1;
            int r2 = points[routes[i][1]-1][0]-1;
            int c2 = points[routes[i][1]-1][1]-1;
            int time = 0;
            if(check[r1][c1][time]){
                if(!check2[r1][c1][time]){
                    answer++;
                  }
                check2[r1][c1][time] = true;
            }
                check[r1][c1][time] = true;
            while(r1 != r2){
                if(r1 > r2)
                    r1--;
                else
                    r1++;
                time++;
                if(check[r1][c1][time]){
                    if(!check2[r1][c1][time]){
                    answer++;
                    }
                      check2[r1][c1][time] = true;
                }else
                check[r1][c1][time] = true;
            }
            while(c1 != c2){
                if(c1 > c2)
                    c1--;
                else
                    c1++;
                time++;
                 if(check[r1][c1][time]){
                    if(!check2[r1][c1][time]){
                    answer++;
                    }
                      check2[r1][c1][time] = true;
                }else
                check[r1][c1][time] = true;
            }
        }
        return answer;
    }
}

//정확성  테스트
//테스트 1 〉	통과 (78.26ms, 283MB)
//테스트 2 〉	통과 (79.04ms, 265MB)
//테스트 3 〉	실패 (114.40ms, 338MB)
//테스트 4 〉	통과 (72.95ms, 276MB)
//테스트 5 〉	통과 (70.01ms, 274MB)
//테스트 6 〉	실패 (70.74ms, 262MB)
//테스트 7 〉	실패 (72.37ms, 261MB)
//테스트 8 〉	실패 (76.72ms, 273MB)
//테스트 9 〉	실패 (98.88ms, 271MB)
//테스트 10 〉	실패 (87.79ms, 271MB)
//테스트 11 〉	실패 (76.25ms, 282MB)
//테스트 12 〉	실패 (89.67ms, 261MB)
//테스트 13 〉	실패 (84.98ms, 282MB)
//테스트 14 〉	실패 (94.93ms, 283MB)
//테스트 15 〉	실패 (159.60ms, 328MB)
//테스트 16 〉	실패 (90.65ms, 271MB)
//테스트 17 〉	실패 (110.84ms, 275MB)
//테스트 18 〉	실패 (128.20ms, 336MB)
//테스트 19 〉	실패 (99.51ms, 263MB)
//테스트 20 〉	실패 (81.88ms, 265MB)
//채점 결과
//정확성: 20.0
//합계: 20.0 / 100.0