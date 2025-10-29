import java.util.*;

/**

    테스트 1 〉	통과 (8.41ms, 89.2MB)
    테스트 2 〉	통과 (7.23ms, 86.9MB)
    테스트 3 〉	통과 (8.58ms, 92.2MB)
    테스트 4 〉	통과 (8.04ms, 86.9MB)
    테스트 5 〉	통과 (9.12ms, 84.4MB)
    테스트 6 〉	통과 (13.46ms, 76.7MB)
    테스트 7 〉	통과 (7.15ms, 87.2MB)
    테스트 8 〉	통과 (7.34ms, 81.1MB)
    테스트 9 〉	통과 (10.70ms, 90.2MB)
    테스트 10 〉	통과 (9.32ms, 84.1MB)
    테스트 11 〉	통과 (8.33ms, 81.3MB)
    테스트 12 〉	통과 (9.85ms, 72.7MB)
    테스트 13 〉	통과 (10.36ms, 79.9MB)
    테스트 14 〉	통과 (6.95ms, 79.9MB)
    테스트 15 〉	통과 (9.31ms, 75.7MB)
    테스트 16 〉	통과 (7.38ms, 81.3MB)
    테스트 17 〉	통과 (8.24ms, 83.1MB)
    테스트 18 〉	통과 (11.41ms, 90.3MB)
    테스트 19 〉	통과 (12.52ms, 76.5MB)
    테스트 20 〉	통과 (16.39ms, 92.8MB)
    테스트 21 〉	통과 (9.73ms, 85.1MB)
    테스트 22 〉	통과 (10.66ms, 72.7MB)
    테스트 23 〉	통과 (0.08ms, 72.2MB)
    테스트 24 〉	통과 (10.36ms, 94.8MB)
    테스트 25 〉	통과 (0.05ms, 86.5MB)
    테스트 26 〉	통과 (0.08ms, 84.2MB)
    테스트 27 〉	통과 (10.00ms, 83.8MB)
    테스트 28 〉	통과 (0.15ms, 73.7MB)
    테스트 29 〉	통과 (10.99ms, 85.6MB)
    테스트 30 〉	통과 (10.33ms, 73.8MB)
    테스트 31 〉	통과 (8.54ms, 91.8MB)


**/

class Solution {
    public static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public char[][] arr = new char[5][5];
    
    public static boolean isInRange(int x, int y) {
        return 0 <= x && x< 5 && 0 <= y && y < 5;
    }
    
    public List<Integer> solution(String[][] places) {
        List<Integer> ans = new ArrayList<>();
        
        testcase : for(int t =0; t< places.length; t++) {
            
            for(int i=0;i<5;i++) {
                arr[i] = places[t][i].toCharArray();
            }
            
            for(int i=0;i<5;i++) {
                for(int j=0;j<5;j++) {
                    if(arr[i][j] == 'P') {
                        // 거리 체크

                        Queue<int[]> check = new ArrayDeque<>();
                        
                        for(int idx=0;idx<4;idx++) {
                            int x = i+dx[idx], y = j+dy[idx];
                            if(isInRange(x, y) && arr[x][y] == 'P') {
                                System.out.println(x+" "+y);
                                ans.add(0); continue testcase;
                            }
                            
                            else if(isInRange(x, y) && arr[x][y] == 'O') {
                                check.add(new int[] {x, y, idx});
                            }
                            
                        }
                        
                        while(!check.isEmpty()) {
                            int[] loc = check.poll();
                            
                            for(int idx=0;idx<4; idx++) {
                                if(idx == 0 && loc[2] == 2) {
                                    continue;
                                }
                                if(idx == 2 && loc[2] == 0) {
                                    continue;
                                }
                                if(idx == 1 && loc[2] == 3) {
                                    continue;
                                }
                                if(idx == 3 && loc[2] == 1) {
                                    continue;
                                }
                                
                                int x = loc[0]+dx[idx], y = loc[1]+dy[idx];
                                if(isInRange(x, y) && arr[x][y] == 'P') {
                                    System.out.println(x+" "+y);
                                    ans.add(0); continue testcase;
                                }
                            }
                        }

                    }
                }
            }
            ans.add(1);
        }
        

        
        return ans;
    }
}
