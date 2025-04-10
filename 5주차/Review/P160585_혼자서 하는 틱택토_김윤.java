class Solution {
    public int solution(String[] board) {
        char[][] game = new char[3][3];
        
        for (int i = 0; i < 3; i++) {
            String value = board[i];
            for (int j = 0; j < 3; j++) {
                game[i][j] = value.charAt(j);
            }
        }
        
        int o_count = 0;
        int x_count = 0;
        
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (game[r][c] == 'O') o_count++;
                else if (game[r][c] == 'X') x_count++;
            }
        }
        
        if (x_count > o_count || o_count - x_count > 1) return 0;
        if (isWin(game, 'O') && o_count != x_count + 1) return 0;
        if (isWin(game, 'X') && o_count != x_count) return 0;
        
        return 1;
    }
    
    static boolean isWin(char[][] game, char player) {
        for (int i = 0; i < 3; i++) {
            if (game[i][0] == player && game[i][1] == player && game[i][2] == player) return true;
            if (game[0][i] == player && game[1][i] == player && game[2][i] == player) return true;
        }
        
        if (game[0][0] == player && game[1][1] == player && game[2][2] == player) return true;
        if (game[0][2] == player && game[1][1] == player && game[2][0] == player) return true;
        
        return false;
    }
}
