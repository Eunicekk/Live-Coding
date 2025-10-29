import java.util.*;

class Solution {
    static List<Integer> list = new ArrayList<>();
    static char[][] map;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static class Point {
        int r = 0;
        int c = 0;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public List<Integer> solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        visit = new boolean[maps.length][maps[0].length()];
        
        for (int r = 0; r < maps.length; r++) {
            String str = maps[r];
            
            for (int c = 0; c < maps[0].length(); c++) {
                map[r][c] = str.charAt(c);
            }
        }
        
        for (int r = 0; r < maps.length; r++) {
            for (int c = 0; c < maps[0].length(); c++) {
                if (map[r][c] != 'X' && !visit[r][c]) {
                    bfs(r, c);
                }
            }
        }
        
        if (list.isEmpty()) {
            list.add(-1);
            return list;
        };
        
        int[] array = new int[list.size()];
        
        Collections.sort(list);
        
        return list;
    }
    
    static void bfs(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        int sum = (map[r][c] - '0');
        queue.offer(new Point(r, c));
        visit[r][c] = true;
        
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = point.r + dr[d];
                int nc = point.c + dc[d];
                
                if (nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length && !visit[nr][nc] && map[nr][nc] != 'X') {
                    sum += (map[nr][nc] - '0');
                    queue.offer(new Point(nr, nc));
                    visit[nr][nc] = true;
                }
            }
        }
        
        list.add(sum);
    }
}
