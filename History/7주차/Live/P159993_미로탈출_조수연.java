import java.util.*;
/**
  테스트 1 〉	통과 (0.35ms, 82.7MB)
  테스트 2 〉	통과 (0.61ms, 84.4MB)
  테스트 3 〉	통과 (0.83ms, 72.8MB)
  테스트 4 〉	통과 (0.65ms, 85MB)
  테스트 5 〉	통과 (0.57ms, 78.7MB)
  테스트 6 〉	통과 (0.44ms, 87MB)
  테스트 7 〉	통과 (1.81ms, 79.7MB)
  테스트 8 〉	통과 (3.55ms, 84.3MB)
  테스트 9 〉	통과 (0.39ms, 83.6MB)
  테스트 10 〉	통과 (0.29ms, 75.1MB)
  테스트 11 〉	통과 (1.30ms, 72.4MB)
  테스트 12 〉	통과 (2.85ms, 79.9MB)
  테스트 13 〉	통과 (4.63ms, 78MB)
  테스트 14 〉	통과 (2.66ms, 82.7MB)
  테스트 15 〉	통과 (0.90ms, 83.6MB)
  테스트 16 〉	통과 (8.05ms, 75.6MB)
  테스트 17 〉	통과 (12.72ms, 91MB)
  테스트 18 〉	통과 (0.83ms, 76.3MB)
  테스트 19 〉	통과 (0.64ms, 74.5MB)
  테스트 20 〉	통과 (7.15ms, 73.9MB)
  테스트 21 〉	통과 (2.40ms, 81.5MB)
  테스트 22 〉	통과 (0.79ms, 94.1MB)
  테스트 23 〉	통과 (0.35ms, 89MB)
**/
class Solution {
    static char[][] arr;
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    
    static class Loc {
        int x, y;
        
        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        
        arr = new char[maps.length][maps[0].length()];
        Queue<Loc> queue = new ArrayDeque<>();
        
        for(int i=0;i<maps.length;i++) {
            arr[i] = maps[i].toCharArray();
            for(int j=0;j<arr[i].length;j++) {
                if(arr[i][j] == 'S') {
                    queue.offer(new Loc(i, j));
                }
            }
        }
        
        int time = 0;
        boolean pulled = false;
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        
        // 레버 올리기
        while(!pulled && !queue.isEmpty()) {
            time++;
            Queue<Loc> newQueue = new ArrayDeque<>();
            
            c: while(!queue.isEmpty()) {
                Loc loc = queue.poll();
                if(visited[loc.x][loc.y]) continue;
                visited[loc.x][loc.y] = true;
                
                for(int i=0;i<4;i++) {
                    int x = loc.x + dx[i], y = loc.y + dy[i];
                    if(!isInRange(x, y) || visited[x][y] || arr[x][y] == 'X') continue;
                    
                    if(arr[x][y] == 'L') {
                        newQueue.clear();
                        newQueue.offer(new Loc(x, y));
                        pulled = true;
                        break c;
                    }

                    
                    newQueue.offer(new Loc(x, y));
                }
            }

            queue = newQueue;
            
        }
        
        if(!pulled) return -1;
        visited = new boolean[arr.length][arr[0].length];
        
        // 출구 찾기
        while(!queue.isEmpty()) {
            
            time++;
            Queue<Loc> newQueue = new ArrayDeque<>();
            
            while(!queue.isEmpty()) {
                Loc loc = queue.poll();
                // System.out.println(loc.x+" "+loc.y);
                if(visited[loc.x][loc.y]) continue;
                visited[loc.x][loc.y] = true;
                
                for(int i=0;i<4;i++) {
                    int x = loc.x + dx[i], y = loc.y + dy[i];
                    if(!isInRange(x, y) || visited[x][y] || arr[x][y] == 'X') continue;
                    
                    if(arr[x][y] == 'E') {
                        return time;
                    }
                    
                    newQueue.offer(new Loc(x, y));
                }
            }           
            queue = newQueue;
        }
        
        return -1;
    }
    
    static boolean isInRange(int x, int y) {
        return 0 <= x && x < arr.length && 0 <= y && y < arr[0].length;
    }
}
