import java.util.*;

/*
    테스트 1 〉	통과 (0.06ms, 94.9MB)
    테스트 2 〉	통과 (0.40ms, 70.6MB)
    테스트 3 〉	통과 (0.35ms, 72MB)
    테스트 4 〉	통과 (3.87ms, 74.7MB)
    테스트 5 〉	통과 (1.28ms, 72.4MB)
    테스트 6 〉	통과 (1.67ms, 86.4MB)
    테스트 7 〉	통과 (1.41ms, 86.1MB)
    테스트 8 〉	통과 (1.91ms, 70MB)
    테스트 9 〉	통과 (3.71ms, 94.4MB)
    테스트 10 〉	통과 (3.68ms, 75.7MB)
    테스트 11 〉	통과 (3.86ms, 93.2MB)
    테스트 12 〉	통과 (4.42ms, 87.7MB)
    테스트 13 〉	통과 (3.41ms, 75MB)
    테스트 14 〉	통과 (4.19ms, 79MB)
    테스트 15 〉	통과 (4.03ms, 69.3MB)
    테스트 16 〉	통과 (5.32ms, 90.7MB)
    테스트 17 〉	통과 (1.00ms, 77.7MB)
    테스트 18 〉	통과 (4.79ms, 70.5MB)
    테스트 19 〉	통과 (8.15ms, 79.1MB)
    테스트 20 〉	통과 (0.89ms, 77.6MB)
    테스트 21 〉	통과 (1.45ms, 89.9MB)
    테스트 22 〉	통과 (0.54ms, 82.6MB)
    테스트 23 〉	통과 (10.96ms, 87MB)
    테스트 24 〉	통과 (4.40ms, 80.8MB)
    테스트 25 〉	통과 (0.74ms, 72.1MB)
*/

class Solution {
    static class Loc {
        int x, y;
        
        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1}, size;
    static boolean visited[][];
    static char[][] arr;
    public int[] solution(String[] maps) {

        List<Integer> set = new ArrayList<>();
        
        arr = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                arr[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i=0;i<arr.length;i++) {            
            for(int j=0;j<arr[i].length;j++) {
                
                if(!visited[i][j] && arr[i][j] != 'X') {
                    visited[i][j] = true;
                    set.add(bfs(i, j));
                }
            }
        }
        
        Collections.sort(set);
        int[] ans = new int[set.size() == 0 ? 1 : set.size()];
        for(int i=0;i<set.size();i++) {
            ans[i] = set.get(i);
        }
        
        if(ans[0] == 0) ans[0] = -1;
        return ans;
    }
    
    public static int bfs(int a, int b) {
        int size = arr[a][b] - '0';
        Queue<Loc> queue = new ArrayDeque<>();
        queue.offer(new Loc(a, b));
        
        // bfs
        while(!queue.isEmpty()) {
            Loc loc = queue.poll();
            for(int i=0;i<4;i++) {
                int x = loc.x + dx[i], y = loc.y + dy[i];
                if(isInRange(x, y) && !visited[x][y] && arr[x][y] != 'X') {
                    visited[x][y] = true;
                    size += arr[x][y] - '0';
                    queue.offer(new Loc(x, y));
                }
            }
        }
        return size;
    }
    
    public static boolean isInRange(int x, int y) {
        return 0 <= x && x < arr.length && 0 <= y && y < arr[0].length;
    }
}
