class Solution {
    public int solution(String[] board) {
        int Ocount = 0;
        int Xcount = 0;
        boolean Oline = false;
        boolean Xline = false;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j< 3; j++){
               if( board[i].charAt(j) == 'O' ){
                   Ocount++;
               }else if ( board[i].charAt(j) == 'X' ){
                   Xcount++;
               }
            }
        }
         for(int i = 0; i < 3; i++){
            if(board[i].charAt(0) == 'O' && board[i].charAt(1) == 'O' && board[i].charAt(2) == 'O'){
                Oline = true;
            }else if(board[i].charAt(0) == 'X' && board[i].charAt(1) == 'X' && board[i].charAt(2) == 'X'){
                Xline = true;
            }
        }
        for(int i = 0; i < 3; i++){
            if(board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O' && board[2].charAt(i) == 'O'){
                Oline = true;
            }else if(board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X'){
                Xline = true;
            }
        }
        if(board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O'){
                Oline = true;
            }else if(board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X'){
                Xline = true;
            }
         if(board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O'){
                Oline = true;
            }else if(board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X'){
                Xline = true;
            }
        if(Ocount - Xcount > 1 || Ocount - Xcount < 0)
            return 0;
        if(Oline){
               if(Ocount - Xcount != 1)
                   return 0;
        }
        if(Xline){
               if(Ocount - Xcount != 0)
                   return 0;
        }
        if(Xline && Oline){
                   return 0;
        }
        
        
        
        return 1;
    }
}


//정확성  테스트
//테스트 1 〉	통과 (0.03ms, 77.6MB)
//테스트 2 〉	통과 (0.03ms, 87.2MB)
//테스트 3 〉	통과 (0.04ms, 80MB)
//테스트 4 〉	통과 (0.03ms, 82.9MB)
//테스트 5 〉	통과 (0.02ms, 74.6MB)
//테스트 6 〉	통과 (0.02ms, 79.1MB)
//테스트 7 〉	통과 (0.02ms, 72.4MB)
//테스트 8 〉	통과 (0.02ms, 86.9MB)
//테스트 9 〉	통과 (0.02ms, 77.4MB)
//테스트 10 〉	통과 (0.04ms, 88.2MB)
//테스트 11 〉	통과 (0.02ms, 84.6MB)
//테스트 12 〉	통과 (0.02ms, 85.3MB)
//테스트 13 〉	통과 (0.03ms, 81.5MB)
//테스트 14 〉	통과 (0.02ms, 77.8MB)
//테스트 15 〉	통과 (0.02ms, 85.4MB)
//테스트 16 〉	통과 (0.02ms, 72.6MB)
//테스트 17 〉	통과 (0.03ms, 93.4MB)
//테스트 18 〉	통과 (0.02ms, 84.7MB)
//테스트 19 〉	통과 (0.03ms, 74.3MB)
//테스트 20 〉	통과 (0.02ms, 91.5MB)
//테스트 21 〉	통과 (0.02ms, 78.9MB)
//테스트 22 〉	통과 (0.03ms, 77.8MB)
//테스트 23 〉	통과 (0.02ms, 72.5MB)
//테스트 24 〉	통과 (0.03ms, 79.2MB)
//테스트 25 〉	통과 (0.02ms, 91.9MB)
//테스트 26 〉	통과 (0.03ms, 85.1MB)
//테스트 27 〉	통과 (0.03ms, 90MB)
//테스트 28 〉	통과 (0.02ms, 74.7MB)
//테스트 29 〉	통과 (0.03ms, 74.3MB)
//테스트 30 〉	통과 (0.04ms, 85.7MB)
//테스트 31 〉	통과 (0.03ms, 71.3MB)
//테스트 32 〉	통과 (0.02ms, 74.8MB)
//테스트 33 〉	통과 (0.03ms, 75.5MB)
//테스트 34 〉	통과 (0.03ms, 83.5MB)
//테스트 35 〉	통과 (0.03ms, 84.4MB)
//테스트 36 〉	통과 (0.02ms, 73.8MB)
//테스트 37 〉	통과 (0.03ms, 80.1MB)
//테스트 38 〉	통과 (0.03ms, 86.2MB)
//테스트 39 〉	통과 (0.03ms, 73.9MB)
//테스트 40 〉	통과 (0.03ms, 86.5MB)
//테스트 41 〉	통과 (0.02ms, 78.9MB)
//테스트 42 〉	통과 (0.02ms, 88.8MB)
//테스트 43 〉	통과 (0.03ms, 82.6MB)
//테스트 44 〉	통과 (0.03ms, 83.2MB)
//테스트 45 〉	통과 (0.02ms, 77MB)
//테스트 46 〉	통과 (0.05ms, 86.4MB)
//테스트 47 〉	통과 (0.02ms, 75.4MB)
//테스트 48 〉	통과 (0.02ms, 82.5MB)
//테스트 49 〉	통과 (0.02ms, 69.5MB)
//테스트 50 〉	통과 (0.02ms, 98.4MB)
//테스트 51 〉	통과 (0.03ms, 84.8MB)
//테스트 52 〉	통과 (0.04ms, 86.7MB)
//테스트 53 〉	통과 (0.03ms, 83.2MB)
//테스트 54 〉	통과 (0.02ms, 80.6MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0