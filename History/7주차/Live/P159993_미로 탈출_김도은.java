import java.util.*;
import java.io.*;

class Solution {
    static class Now {
        int r;
        int c;
        int dist;
        
        public Now(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char[][] board;
    static int R, C;
    static int answer;
        
    public int solution(String[] maps) {
        
        R = maps.length;
        C = maps[0].length();
        
        board = new char[R][C];
        
        int startR = 0;
        int startC = 0;
        int laverR = 0;
        int laverC = 0;
        int exitR = 0;
        int exitC = 0;
        
        for(int r = 0; r < R; r++) {
            String str = maps[r];
            for(int c = 0; c < C; c++) {
                board[r][c] = str.charAt(c);
                if(board[r][c] == 'S') {
                    startR = r;
                    startC = c;
                } else if(board[r][c] == 'L') {
                    laverR = r;
                    laverC = c;
                } else if(board[r][c] == 'E') {
                    exitR = r;
                    exitC = c;
                }
            }
        }
        
        answer = 0;
        
        bfs(startR, startC, laverR, laverC);
        if(answer == -1) return answer;
        
        bfs(laverR, laverC, exitR, exitC);

        return answer;
    }
    
    public static void bfs(int startR, int startC, int endR, int endC) {
        Queue<Now> queue = new LinkedList<>();
        boolean[][] visit = new boolean[R][C];
        
        queue.add(new Now(startR, startC, 0));
        visit[startR][startC] = true;
        
        while(!queue.isEmpty()){
            Now now = queue.poll();
            
            if(now.r == endR && now.c == endC) {
                answer += now.dist;
                return;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                
                if(nr < 0 || nr >= R || nc < 0 || nc >= C || visit[nr][nc] || board[nr][nc] == 'X') continue;
                
                queue.add(new Now(nr, nc, now.dist + 1));
                visit[nr][nc] = true;
            }
        }
        
        answer = -1;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.52ms, 71.5MB)
테스트 2 〉	통과 (0.54ms, 74.3MB)
테스트 3 〉	통과 (0.67ms, 81.6MB)
테스트 4 〉	통과 (0.67ms, 69.6MB)
테스트 5 〉	통과 (0.50ms, 79.7MB)
테스트 6 〉	통과 (0.49ms, 89.1MB)
테스트 7 〉	통과 (1.60ms, 74.1MB)
테스트 8 〉	통과 (2.95ms, 85.8MB)
테스트 9 〉	통과 (0.34ms, 74.8MB)
테스트 10 〉	통과 (0.35ms, 70.3MB)
테스트 11 〉	통과 (1.27ms, 89MB)
테스트 12 〉	통과 (2.52ms, 87MB)
테스트 13 〉	통과 (3.17ms, 79.5MB)
테스트 14 〉	통과 (3.31ms, 72.6MB)
테스트 15 〉	통과 (1.05ms, 73.8MB)
테스트 16 〉	통과 (4.62ms, 89.2MB)
테스트 17 〉	통과 (7.83ms, 81MB)
테스트 18 〉	통과 (0.65ms, 76.2MB)
테스트 19 〉	통과 (0.55ms, 84.7MB)
테스트 20 〉	통과 (4.35ms, 95.3MB)
테스트 21 〉	통과 (2.30ms, 89.3MB)
테스트 22 〉	통과 (0.55ms, 84.3MB)
테스트 23 〉	통과 (0.36ms, 80.8MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
