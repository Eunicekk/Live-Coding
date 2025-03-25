import java.util.*;

class Solution {
    static int W, H, pX, pY;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static char[][] arr;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        H = park.length;
        W = park[0].length();
        arr = new char[H][W];
        
        for(int i=0;i<H;i++) {
            for(int j=0;j<W;j++) {
                arr[i][j] = park[i].charAt(j);
            }
        }
        
        findPoint: for(int i=0;i<H;i++) {
            for(int j=0;j<W;j++) {
                if(arr[i][j] == 'S') {
                    pX = i;
                    pY = j;
                    
                    arr[i][j] = 'O';
                    break findPoint;
                }
            }
        }
        
        for(int i=0;i<routes.length;i++) {
            
            int idx = 0;
            int time = Integer.parseInt(Character.toString(routes[i].charAt(2)));
            
            System.out.println(idx +" " + time);
            
            switch(routes[i].charAt(0)) {
                case 'N':
                    
                    break;
                case 'S':
                    idx = 2;
                    break;
                
                case 'W':
                    idx = 3;
                    break;
                
                case 'E':
                    idx = 1;
                    break;
            }
            
            if(isInRange(pX+dx[idx]*time, pY+dy[idx]*time)) temp(idx, time);
            
        }
        
        answer[0] = pX;
        answer[1] = pY;
        
        return answer;
    }
    
    
    public static boolean isInRange(int x, int y) {
        return 0 <= x && x < H && 0 <= y && y < W;
    }
    
    public static void temp(int idx, int time) {
        int nX = pX;
        int nY = pY;
        for(int i=1;i<=time;i++) {
            if(arr[nX+=dx[idx]][nY+=dy[idx]] == 'X') return;
        }
        
        pX = nX;
        pY = nY;
    }
}
