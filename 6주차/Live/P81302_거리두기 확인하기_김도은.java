import java.util.*;
import java.io.*;

class Solution {
    
    //팔방탐색
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        
        int T = places.length;
        
        int[] answer = new int[T];
        
        to: for(int t = 0; t < T; t++) {
            
            char[][] room = new char[5][5];
            
            for(int r = 0; r < 5; r++) {
                String str = places[t][r];
                for(int c = 0; c < 5; c++) {
                    room[r][c] = str.charAt(c);
                }
            } //입력 완료
            
            for(int r = 0; r < 5; r++) {
                for(int c = 0; c < 5; c++) {
                    if(room[r][c] == 'P') {
                        if(!bfs(room, r, c)) {
                            answer[t] = 0;
                            continue to;
                        };
                    }
                }
            } //bfs
            
            answer[t] = 1;
            
        } //테케돌리기
        
        return answer;
    }
    
    public static boolean bfs(char[][] room, int R, int C) {
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[5][5];
        
        queue.add(new int[]{R, C});
        visit[R][C] = true;
        
        while(!queue.isEmpty()) {
            
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            
            int dist = Math.abs(r - R) + Math.abs(c - C);
            
            //자기자신이거나 거리가 멀면 하지 않는다
            if(dist > 2) continue;
            
            if(dist == 1) {
                if(room[r][c] == 'P') return false;
            } else if(dist == 2 && room[r][c] == 'P') {
                //일직선일때
                if(r == R) {
                    if(room[r][(c+C)/2] == 'O') return false; //칸막이 없으면
                }
                
                if(c == C) {
                    if(room[(r+R)/2][c] == 'O') return false; //칸막이 없으면
                }
                
                //대각선일때
                if(room[r][C] == 'O' || room[R][c] == 'O') return false;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visit[nr][nc]) continue;
                
                queue.add(new int[]{nr, nc});
                visit[nr][nc] = true;
            }
            
        }
        
        return true;
    }
    
}

/*
정확성  테스트
테스트 1 〉	통과 (0.55ms, 80MB)
테스트 2 〉	통과 (0.26ms, 84.4MB)
테스트 3 〉	통과 (0.36ms, 88.1MB)
테스트 4 〉	통과 (0.22ms, 75.1MB)
테스트 5 〉	통과 (0.18ms, 97.5MB)
테스트 6 〉	통과 (0.22ms, 82.8MB)
테스트 7 〉	통과 (0.29ms, 87.8MB)
테스트 8 〉	통과 (4.92ms, 74.5MB) //왜그럴까?
테스트 9 〉	통과 (0.20ms, 72.8MB)
테스트 10 〉	통과 (0.20ms, 72.6MB)
테스트 11 〉	통과 (0.32ms, 92.2MB)
테스트 12 〉	통과 (0.17ms, 73.1MB)
테스트 13 〉	통과 (0.26ms, 72.4MB)
테스트 14 〉	통과 (0.19ms, 79.6MB)
테스트 15 〉	통과 (0.17ms, 86.1MB)
테스트 16 〉	통과 (0.32ms, 77.5MB)
테스트 17 〉	통과 (0.29ms, 75.2MB)
테스트 18 〉	통과 (0.27ms, 79.9MB)
테스트 19 〉	통과 (0.28ms, 72.6MB)
테스트 20 〉	통과 (0.24ms, 88.4MB)
테스트 21 〉	통과 (0.16ms, 76.7MB)
테스트 22 〉	통과 (0.26ms, 75.9MB)
테스트 23 〉	통과 (0.03ms, 76.5MB)
테스트 24 〉	통과 (0.11ms, 76MB)
테스트 25 〉	통과 (0.04ms, 82.7MB)
테스트 26 〉	통과 (0.03ms, 81.9MB)
테스트 27 〉	통과 (0.20ms, 86.7MB)
테스트 28 〉	통과 (0.28ms, 86.6MB)
테스트 29 〉	통과 (0.33ms, 71.7MB)
테스트 30 〉	통과 (0.24ms, 98MB)
테스트 31 〉	통과 (0.22ms, 76.1MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
