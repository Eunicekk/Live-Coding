import java.util.*;

/*

최적화 X
테스트 1 〉	통과 (15.05ms, 77MB)
테스트 2 〉	통과 (6.67ms, 77.7MB)
테스트 3 〉	통과 (7.94ms, 78.7MB)
테스트 4 〉	통과 (17.39ms, 80.2MB)
테스트 5 〉	통과 (32.44ms, 102MB)
테스트 6 〉	통과 (29.87ms, 104MB)
테스트 7 〉	통과 (45.43ms, 111MB)
테스트 8 〉	통과 (122.54ms, 126MB)
테스트 9 〉	통과 (149.90ms, 183MB)
테스트 10 〉	통과 (87.34ms, 143MB)
테스트 11 〉	통과 (138.59ms, 133MB)
테스트 12 〉	통과 (171.24ms, 128MB)
테스트 13 〉	통과 (148.72ms, 183MB)
테스트 14 〉	통과 (304.81ms, 311MB)
테스트 15 〉	통과 (325.75ms, 327MB)
테스트 16 〉	통과 (323.85ms, 324MB)
테스트 17 〉	통과 (369.03ms, 377MB)
테스트 18 〉	통과 (447.14ms, 380MB)
테스트 19 〉	통과 (338.50ms, 355MB)
테스트 20 〉	통과 (339.62ms, 336MB)

*/

class Solution {
    
    static int[][] points, routes;
    
    static class Loc {
        int x, y;
        
        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        Loc(int a) {
            this.x = points[a][0];
            this.y = points[a][1];
        }
    }
    
    static class Robot {
        int idx;
        Loc loc;
        int stage;
        
        Robot(Loc loc, int idx) {
            this.idx = idx;
            this.loc = loc;
            stage = 1;
        }
    }
    
    static Queue<Robot> queue = new ArrayDeque<>();
    
    public int solution(int[][] points, int[][] routes) {
        
        this.points = points;
        this.routes = routes;
        
        int ans = 0;
                    
        int[][] visited = new int[101][101];
        
        // 로봇의 시작 위치를 담아 Queue에 넣기
        for(int i=0;i<routes.length;i++) {
            
            int pointIdx = routes[i][0]-1;
            
            Loc loc = new Loc(points[pointIdx][0]-1, points[pointIdx][1]-1);
            queue.offer(new Robot(loc, i));
            visited[loc.x][loc.y]++;
            // System.out.println(loc.x+" "+loc.y);
        }
        
                    
        for(int i=0;i<101;i++) {
            for(int j=0;j<101;j++) {
                if(visited[i][j] > 1) {
                    ans++;
                }
            }
        }
        
        while(!queue.isEmpty()) {
            
            visited = new int[101][101];
            Queue<Robot> newQueue = new ArrayDeque<>();
            
            while(!queue.isEmpty()) {
                Robot robot = queue.poll();
                

                
                int pointIdx = routes[robot.idx][robot.stage]-1;
                
                Loc target = new Loc(points[pointIdx][0]-1, points[pointIdx][1]-1);
                Loc nowLoc = robot.loc;
                
                // System.out.print(pointIdx+" "+ nowLoc.x+" "+nowLoc.y+" "+target.x+" "+target.y);
                                
                // 위치 도달 확인
                if(nowLoc.x == target.x && nowLoc.y == target.y) {
                    robot.stage++;
                }
                
                if(robot.stage >= routes[robot.idx].length) {
                    continue;
                }
                
                pointIdx = routes[robot.idx][robot.stage]-1;
                
                target = new Loc(points[pointIdx][0]-1, points[pointIdx][1]-1);
                nowLoc = robot.loc;
                
                // 위치 조정
                if(nowLoc.x == target.x) {
                    if (nowLoc.y > target.y) nowLoc.y--;
                    else nowLoc.y++;
                } else {
                    if (nowLoc.x > target.x) nowLoc.x--;
                    else nowLoc.x++;
                }
                
                visited[nowLoc.x][nowLoc.y]++;
                
                // System.out.println("-> "+nowLoc.x+" "+nowLoc.y);

                robot.loc = nowLoc;
                newQueue.offer(robot);
            }
            
            for(int i=0;i<101;i++) {
                for(int j=0;j<101;j++) {
                    if(visited[i][j] > 1) {
                        // System.out.println(i+" "+j+" "+visited[i][j]);
                        ans++;
                    }
                }
            }
            // System.out.println("----------");
            
            queue = newQueue;
        }
        
        
        return ans;
    }
}
