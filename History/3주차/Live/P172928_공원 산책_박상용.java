class Solution {
    public int[] solution(String[] park, String[] routes) {
        int n = park[0].length();
        int m = park.length;
        char[][] arr = new char[m][n];
        int startr = 0;
        int startc = 0;
        for(int r = 0; r < m; r++){
            for(int c = 0; c<n; c++){
                arr[r][c] = park[r].charAt(c);
                if(park[r].charAt(c) == 'S'){
                startr = r;
                    startc = c;
                }
            }
        }
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        int d = 0;
        int nr = startr;
        int nc = startc;
        out:  for(int i = 0; i < routes.length; i++){
             if(routes[i].charAt(0) == 'E'){
                d = 3;
             }else if(routes[i].charAt(0) == 'S'){
                 d = 1;
             }else if(routes[i].charAt(0) == 'W'){
                 d = 2;
             }else{
                 d= 0;
             }
             int k = routes[i].charAt(2)-'0';
             for(int j =0 ; j < k; j++){
                 nr += dr[d];
                 nc += dc[d];
                 if(nr < 0 || nc < 0 || nr >= m || nc >= n || arr[nr][nc] == 'X'){
                     nr = startr;
                     nc = startc;
                     continue out;
                 }
             }
            startr = nr;
            startc = nc;
         }
        int[] answer = {startr,startc};
        return answer;
    }
}

//테스트 1 〉	통과 (0.04ms, 87MB)
//테스트 2 〉	통과 (0.03ms, 81.4MB)
//테스트 3 〉	통과 (0.05ms, 77.6MB)
//테스트 4 〉	통과 (0.09ms, 85.7MB)
//테스트 5 〉	통과 (0.10ms, 72.9MB)
//테스트 6 〉	통과 (0.16ms, 81.9MB)
//테스트 7 〉	통과 (0.16ms, 70.3MB)
//테스트 8 〉	통과 (0.22ms, 76.7MB)
//테스트 9 〉	통과 (0.20ms, 81.6MB)
//테스트 10 〉	통과 (0.20ms, 73.3MB)
//테스트 11 〉	통과 (0.21ms, 77.6MB)
//테스트 12 〉	통과 (0.20ms, 75.6MB)
//테스트 13 〉	통과 (0.20ms, 78.3MB)
//테스트 14 〉	통과 (0.20ms, 84MB)
//테스트 15 〉	통과 (0.30ms, 73.2MB)
//테스트 16 〉	통과 (0.05ms, 85.2MB)
//테스트 17 〉	통과 (0.08ms, 85.6MB)
//테스트 18 〉	통과 (0.02ms, 88.4MB)
//테스트 19 〉	통과 (0.26ms, 86.1MB)
//테스트 20 〉	통과 (0.05ms, 79.7MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0
