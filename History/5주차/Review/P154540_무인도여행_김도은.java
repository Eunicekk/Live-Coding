import java.util.*;
import java.io.*;

class Solution {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    static ArrayList<Integer> list;
    static int[][] island;
    static int lenR;
    static int lenC;
    static boolean[][] visit;
    
    public int[] solution(String[] maps) {

        lenR = maps.length;
        lenC = maps[0].length();
        
        island = new int[lenR][lenC];
        
        for(int r = 0; r < lenR; r++) {
            String str = maps[r];
            for(int c = 0; c < lenC; c++) {
                char txt = str.charAt(c);
                
                if(txt == 'X') {
                  island[r][c] = 0;
                  // System.out.print(island[r][c] + " ");
                  continue;
                } 
                
                island[r][c] = txt - '0';
                
                // System.out.print(island[r][c] + " ");
            }
            // System.out.println();
        } //입력
        
        list = new ArrayList<>();
        visit = new boolean[lenR][lenC];
        
        for(int r = 0; r < lenR; r++) {
            for(int c = 0; c < lenC; c++) {
                if(island[r][c] > 0 && !visit[r][c]) {
                    int tmp = dfs(r, c);
                    list.add(tmp);
                    // System.out.println(tmp + "days");
                }
            }
        }
        
        Collections.sort(list);
        
        if(list.isEmpty()) return new int[]{-1};
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public int dfs(int R, int C){
        
        visit[R][C] = true;
        // System.out.println(days + "이걸로 dfs");
        int totalDays = island[R][C]; // 현재 위치 값으로 시작
        
        for(int d = 0; d < 4; d++) {
            int nr = R + dr[d];
            int nc = C + dc[d];
            
            if(nr < 0 || nr >= lenR || nc < 0 || nc >= lenC || island[nr][nc] == 0 || visit[nr][nc]) continue;
            
            totalDays += dfs(nr, nc); // 반환된 값을 totalDays에 누적
        }
        
        
        return totalDays;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.05ms, 71.9MB)
테스트 2 〉	통과 (0.07ms, 83MB)
테스트 3 〉	통과 (0.11ms, 88MB)
테스트 4 〉	통과 (0.15ms, 82.3MB)
테스트 5 〉	통과 (0.54ms, 75.5MB)
테스트 6 〉	통과 (0.89ms, 72MB)
테스트 7 〉	통과 (0.36ms, 74MB)
테스트 8 〉	통과 (0.85ms, 90.6MB)
테스트 9 〉	통과 (1.13ms, 80.8MB)
테스트 10 〉	통과 (1.61ms, 74.4MB)
테스트 11 〉	통과 (0.94ms, 80.6MB)
테스트 12 〉	통과 (2.07ms, 89.6MB)
테스트 13 〉	통과 (1.77ms, 87.1MB)
테스트 14 〉	통과 (2.86ms, 69.9MB)
테스트 15 〉	통과 (2.32ms, 74MB)
테스트 16 〉	통과 (3.28ms, 74.7MB)
테스트 17 〉	통과 (0.17ms, 86.9MB)
테스트 18 〉	통과 (2.17ms, 84.9MB)
테스트 19 〉	통과 (2.70ms, 77.6MB)
테스트 20 〉	통과 (0.95ms, 72.3MB)
테스트 21 〉	통과 (0.68ms, 82.8MB)
테스트 22 〉	통과 (0.11ms, 79.2MB)
테스트 23 〉	통과 (5.71ms, 80.5MB)
테스트 24 〉	통과 (4.46ms, 79.8MB)
테스트 25 〉	통과 (0.14ms, 70.7MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
