import java.util.*;
import java.math.*;

class Solution {
    static int[][] map;
    static int[] dir = {-1, 1};
    public List<Integer> solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        
        map = new int[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                map[i][j] = i * columns + j + 1;
            }
        }
        
        for(int[] query : queries) {
            answer.add(moveNumbers(query));
        }
        
        
        return answer;
    }
    
    static int moveNumbers(int[] query) {
        // [[0,0,1,1],[0,1,1,2],[1,0,2,1],[1,1,2,2]]
        int x1 = query[0] - 1, x2 = query[2] - 1;
        int y1 = query[1] - 1, y2 = query[3] - 1;
        
        int num = map[x1][y1];
        int ans = num;
        
        for(int row=x1; row < x2;row++) {
            map[row][y1] = map[row+1][y1];
            ans = Math.min(ans, map[row][y1]);
        }
        
        for(int col = y1; col < y2; col++) {
            map[x2][col] = map[x2][col+1];
            ans = Math.min(ans, map[x2][col]);
        }
        
        for(int row=x2;row>x1;row--) {
            map[row][y2] = map[row-1][y2];
            ans = Math.min(ans, map[row][y2]);
        }
        
        for(int col = y2; col >y1; col--) {
            map[x1][col] = map[x1][col-1];
            ans = Math.min(ans, map[x1][col]);
        }
        
        map[x1][y1+1] = num;
        
        return ans;

    }
    
}