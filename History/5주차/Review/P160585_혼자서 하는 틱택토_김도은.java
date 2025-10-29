class Solution {
    public int solution(String[] board) {
        
        char[][] game = new char[3][3];
        
        for(int r = 0; r < 3; r++) {
            String str = board[r];
            for(int c = 0; c < 3; c++) {
                game[r][c] = str.charAt(c);
            }
        }
        //게임 상황을 받음
        
        int canGame = 1; //게임할 수 있는가 없는가
        //할 수 있는 게 1, 없는 게 0
        
        int countO = 0; //O의 개수
        int countX = 0; //X의 개수
        
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                if(game[r][c] == 'O') {
                    countO++;
                } else if(game[r][c] == 'X') countX++;
            }
        }
        
        boolean winO = false;
        boolean winX = false;

        // 가로 체크
        for(int r = 0; r < 3; r++) {
            if(game[r][0] != '.' && game[r][0] == game[r][1] && game[r][1] == game[r][2]) {
                if(game[r][0] == 'O') winO = true;
                if(game[r][0] == 'X') winX = true;
            }
        }

        // 세로 체크
        for(int c = 0; c < 3; c++) {
            if(game[0][c] != '.' && game[0][c] == game[1][c] && game[1][c] == game[2][c]) {
                if(game[0][c] == 'O') winO = true;
                if(game[0][c] == 'X') winX = true;
            }
        }

        // 대각선 체크
        if(game[0][0] != '.' && game[0][0] == game[1][1] && game[1][1] == game[2][2]) {
            if(game[0][0] == 'O') winO = true;
            if(game[0][0] == 'X') winX = true;
        }
        if(game[0][2] != '.' && game[0][2] == game[1][1] && game[1][1] == game[2][0]) {
            if(game[0][2] == 'O') winO = true;
            if(game[0][2] == 'X') winX = true;
        }

        // 게임 조건 검증
        if((winO && winX) || (winO && countO != countX + 1) || (winX && countO != countX)) {
            canGame = 0;
        } else if(!(countO == countX || countO == countX + 1)) {
            canGame = 0;
        }
        
        
        return canGame;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.04ms, 82.8MB)
테스트 2 〉	통과 (0.02ms, 79.2MB)
테스트 3 〉	통과 (0.04ms, 70.1MB)
테스트 4 〉	통과 (0.02ms, 84.9MB)
테스트 5 〉	통과 (0.03ms, 84MB)
테스트 6 〉	통과 (0.03ms, 87.4MB)
테스트 7 〉	통과 (0.02ms, 74.9MB)
테스트 8 〉	통과 (0.02ms, 73.7MB)
테스트 9 〉	통과 (0.04ms, 88.7MB)
테스트 10 〉	통과 (0.02ms, 76.5MB)
테스트 11 〉	통과 (0.05ms, 80.9MB)
테스트 12 〉	통과 (0.03ms, 87.3MB)
테스트 13 〉	통과 (0.02ms, 78.4MB)
테스트 14 〉	통과 (0.04ms, 83.4MB)
테스트 15 〉	통과 (0.03ms, 89.8MB)
테스트 16 〉	통과 (0.03ms, 81.1MB)
테스트 17 〉	통과 (0.04ms, 84.7MB)
테스트 18 〉	통과 (0.03ms, 74.5MB)
테스트 19 〉	통과 (0.02ms, 72.4MB)
테스트 20 〉	통과 (0.03ms, 79.1MB)
테스트 21 〉	통과 (0.03ms, 81.6MB)
테스트 22 〉	통과 (0.04ms, 87.1MB)
테스트 23 〉	통과 (0.03ms, 85.6MB)
테스트 24 〉	통과 (0.03ms, 85MB)
테스트 25 〉	통과 (0.03ms, 70.6MB)
테스트 26 〉	통과 (0.03ms, 84.3MB)
테스트 27 〉	통과 (0.03ms, 76MB)
테스트 28 〉	통과 (0.03ms, 91.2MB)
테스트 29 〉	통과 (0.02ms, 74.5MB)
테스트 30 〉	통과 (0.03ms, 71.3MB)
테스트 31 〉	통과 (0.03ms, 72.6MB)
테스트 32 〉	통과 (0.05ms, 93.1MB)
테스트 33 〉	통과 (0.03ms, 87.6MB)
테스트 34 〉	통과 (0.03ms, 77.2MB)
테스트 35 〉	통과 (0.02ms, 72.2MB)
테스트 36 〉	통과 (0.03ms, 75.6MB)
테스트 37 〉	통과 (0.03ms, 78.8MB)
테스트 38 〉	통과 (0.03ms, 79.1MB)
테스트 39 〉	통과 (0.04ms, 75.3MB)
테스트 40 〉	통과 (0.03ms, 73.3MB)
테스트 41 〉	통과 (0.02ms, 89.4MB)
테스트 42 〉	통과 (0.04ms, 83.1MB)
테스트 43 〉	통과 (0.02ms, 87.3MB)
테스트 44 〉	통과 (0.04ms, 79.5MB)
테스트 45 〉	통과 (0.03ms, 86.6MB)
테스트 46 〉	통과 (0.04ms, 87.4MB)
테스트 47 〉	통과 (0.03ms, 85.5MB)
테스트 48 〉	통과 (0.03ms, 79.7MB)
테스트 49 〉	통과 (0.04ms, 71.9MB)
테스트 50 〉	통과 (0.04ms, 86.5MB)
테스트 51 〉	통과 (0.02ms, 86.6MB)
테스트 52 〉	통과 (0.04ms, 72.3MB)
테스트 53 〉	통과 (0.03ms, 82.1MB)
테스트 54 〉	통과 (0.03ms, 77.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
