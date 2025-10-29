import java.util.*;

/*
    테스트 1 〉	통과 (0.03ms, 77.6MB)
    테스트 2 〉	통과 (0.04ms, 84.3MB)
    테스트 3 〉	통과 (0.04ms, 71.8MB)
    테스트 4 〉	통과 (0.04ms, 84.6MB)
    테스트 5 〉	통과 (0.04ms, 84.6MB)
    테스트 6 〉	통과 (0.03ms, 83.9MB)
    테스트 7 〉	통과 (0.04ms, 81.2MB)
    테스트 8 〉	통과 (0.03ms, 75.5MB)
    테스트 9 〉	통과 (0.04ms, 84.6MB)
    테스트 10 〉	통과 (0.04ms, 80.5MB)
    테스트 11 〉	통과 (0.03ms, 69.5MB)
    테스트 12 〉	통과 (0.05ms, 73.4MB)
    테스트 13 〉	통과 (0.04ms, 74.7MB)
    테스트 14 〉	통과 (0.03ms, 78.8MB)
    테스트 15 〉	통과 (0.02ms, 72.2MB)
    테스트 16 〉	통과 (0.05ms, 74.8MB)
    테스트 17 〉	통과 (0.03ms, 84.7MB)
    테스트 18 〉	통과 (0.03ms, 77.2MB)
    테스트 19 〉	통과 (0.04ms, 76.2MB)
    테스트 20 〉	통과 (0.03ms, 74.9MB)
    테스트 21 〉	통과 (0.03ms, 85.7MB)
    테스트 22 〉	통과 (0.07ms, 69MB)
    테스트 23 〉	통과 (0.03ms, 81.8MB)
    테스트 24 〉	통과 (0.03ms, 77.8MB)
    테스트 25 〉	통과 (0.04ms, 69.9MB)
    테스트 26 〉	통과 (0.04ms, 78.6MB)
    테스트 27 〉	통과 (0.03ms, 74.1MB)
    테스트 28 〉	통과 (0.03ms, 78.9MB)
    테스트 29 〉	통과 (0.03ms, 83.4MB)
    테스트 30 〉	통과 (0.05ms, 82.3MB)
    테스트 31 〉	통과 (0.03ms, 89.2MB)
    테스트 32 〉	통과 (0.03ms, 85MB)
    테스트 33 〉	통과 (0.02ms, 81.6MB)
    테스트 34 〉	통과 (0.04ms, 82.4MB)
    테스트 35 〉	통과 (0.04ms, 73.4MB)
    테스트 36 〉	통과 (0.05ms, 87MB)
    테스트 37 〉	통과 (0.04ms, 84.6MB)
    테스트 38 〉	통과 (0.03ms, 67.8MB)
    테스트 39 〉	통과 (0.04ms, 75.2MB)
    테스트 40 〉	통과 (0.03ms, 90.7MB)
    테스트 41 〉	통과 (0.02ms, 84.3MB)
    테스트 42 〉	통과 (0.02ms, 72.3MB)
    테스트 43 〉	통과 (0.03ms, 88MB)
    테스트 44 〉	통과 (0.04ms, 84.4MB)
    테스트 45 〉	통과 (0.04ms, 85.3MB)
    테스트 46 〉	통과 (0.03ms, 77.3MB)
    테스트 47 〉	통과 (0.03ms, 72.6MB)
    테스트 48 〉	통과 (0.03ms, 78.6MB)
    테스트 49 〉	통과 (0.02ms, 72.3MB)
    테스트 50 〉	통과 (0.03ms, 85MB)
    테스트 51 〉	통과 (0.03ms, 80.1MB)
    테스트 52 〉	통과 (0.04ms, 89MB)
    테스트 53 〉	통과 (0.03ms, 94.9MB)
    테스트 54 〉	통과 (0.03ms, 81.6MB)
*/

class Solution {
    public int solution(String[] board) {
        int cntO = 0, cntX = 0;
        int winO = 0, winX = 0;
                
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(board[i].charAt(j) == 'O') cntO++;
                else if(board[i].charAt(j) == 'X') cntX++;
            }
            if(board[i].equals("OOO")) winO++;
            else if(board[i].equals("XXX")) winX++;
        }
        
        // 세로
        if(board[0].charAt(0) == 'O' && board[1].charAt(0) == 'O' && board[2].charAt(0) == 'O') winO++;
        if(board[0].charAt(1) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(1) == 'O') winO++;
        if(board[0].charAt(2) == 'O' && board[1].charAt(2) == 'O' && board[2].charAt(2) == 'O') winO++;
        if(board[0].charAt(0) == 'X' && board[1].charAt(0) == 'X' && board[2].charAt(0) == 'X') winX++;
        if(board[0].charAt(1) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(1) == 'X') winX++;
        if(board[0].charAt(2) == 'X' && board[1].charAt(2) == 'X' && board[2].charAt(2) == 'X') winX++;
        
        // 대각선
        if(board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O') winO++;
        if(board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O') winO++;
        if(board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X') winX++;
        if(board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X') winX++;       
        
        // O, X 갯수가 맞지 않을 때
        // O - X == 1 또는 0
      
        if((cntX ==0 && cntO == 0)) return 1;
        
        // OOO XXX 모두 있을 때
        if(!(winX != 0 && winO == 0) && !(winX == 0 & winO != 0) && !(winX == 0 & winO == 0)) return 0;
        
        
        if(cntO - cntX == 1 && winX != 0) return 0;
        if(cntO - cntX == 0 && winO != 0) return 0;
        
        if(cntO - cntX != 1 && cntO - cntX != 0 ) return 0;

        
        return 1;
    }
}
