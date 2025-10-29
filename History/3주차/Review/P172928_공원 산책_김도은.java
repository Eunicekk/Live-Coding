import java.util.*;
import java.io.*;

class Solution {
    
    static int[] dr = {-1, 1, 0, 0}; //상 하 좌 우
    static int[] dc = {0, 0, -1, 1}; //상 하 좌 우
    
    public int[] solution(String[] park, String[] routes) {
        
        int startR = 0;
        int startC = 0;
        
        int lenR = park.length;
        int lenC = park[0].length();
        
        char[][] board = new char[lenR][lenC];
        
        out: for(int r = 0; r < lenR; r++) {
            String str = park[r];

            for(int c = 0; c < lenC; c++) {
                
                board[r][c] = str.charAt(c);
                
                if(str.charAt(c) == 'S') {
                    startR = r;
                    startC = c;
                }
            }
        }
        
        to: for(int i = 0; i < routes.length; i++) {
            String[] order = routes[i].split(" ");
            
            int dir = -1;
            int going = Integer.parseInt(order[1]);
            
            switch (order[0]) {
                case "N" :
                    dir = 0; 
                    break;
                case "S" :
                    dir = 1;
                    break;
                case "W" :
                    dir = 2;
                    break;
                case "E" :
                    dir = 3;
                    break;
            }
            
            for(int j = 1; j <= going; j++) {
                int nr = startR + j * dr[dir];
                int nc = startC + j * dc[dir];
                
                if(nr < 0 || nr >= lenR || nc < 0 || nc >= lenC || board[nr][nc] == 'X') {
                    continue to;
                }
            }
            
            startR += going * dr[dir];
            startC += going * dc[dir];
        }
        
        return new int[]{startR, startC};
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.10ms, 84.5MB)
테스트 2 〉	통과 (0.11ms, 75.2MB)
테스트 3 〉	통과 (0.22ms, 96.4MB)
테스트 4 〉	통과 (0.20ms, 71.3MB)
테스트 5 〉	통과 (2.12ms, 86MB)
테스트 6 〉	통과 (0.40ms, 81MB)
테스트 7 〉	통과 (0.39ms, 88.8MB)
테스트 8 〉	통과 (0.64ms, 86.3MB)
테스트 9 〉	통과 (0.40ms, 74.7MB)
테스트 10 〉	통과 (0.34ms, 88.1MB)
테스트 11 〉	통과 (0.39ms, 80MB)
테스트 12 〉	통과 (0.62ms, 74.4MB)
테스트 13 〉	통과 (0.59ms, 90.6MB)
테스트 14 〉	통과 (0.48ms, 79.6MB)
테스트 15 〉	통과 (0.53ms, 87MB)
테스트 16 〉	통과 (0.13ms, 76.6MB)
테스트 17 〉	통과 (0.27ms, 87.6MB)
테스트 18 〉	통과 (0.12ms, 72.8MB)
테스트 19 〉	통과 (0.39ms, 73.2MB)
테스트 20 〉	통과 (0.16ms, 83.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
