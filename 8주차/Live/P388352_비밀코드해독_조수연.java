import java.util.*;

/**
  테스트 1 〉	통과 (2.16ms, 75.1MB)
  테스트 2 〉	통과 (10.45ms, 76MB)
  테스트 3 〉	통과 (0.52ms, 87.1MB)
  테스트 4 〉	통과 (0.73ms, 93.9MB)
  테스트 5 〉	통과 (0.63ms, 88.1MB)
  테스트 6 〉	통과 (0.86ms, 73.8MB)
  테스트 7 〉	통과 (3.89ms, 79.9MB)
  테스트 8 〉	통과 (3.01ms, 76.4MB)
  테스트 9 〉	통과 (14.40ms, 90.3MB)
  테스트 10 〉	통과 (12.57ms, 78.7MB)
  테스트 11 〉	통과 (15.35ms, 92.1MB)
  테스트 12 〉	통과 (42.47ms, 115MB)
  테스트 13 〉	통과 (38.90ms, 112MB)
  테스트 14 〉	통과 (62.30ms, 115MB)
  테스트 15 〉	통과 (40.52ms, 110MB)
  테스트 16 〉	통과 (47.30ms, 107MB)
  테스트 17 〉	통과 (45.68ms, 92.5MB)
  테스트 18 〉	통과 (45.06ms, 94.2MB)
  테스트 19 〉	통과 (58.17ms, 96.2MB)
  테스트 20 〉	통과 (57.65ms, 111MB)
*/

class Solution {
    static int[] pw = new int[5];
    static int[][] q;
    static int[] ans;
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        this.q = q;
        this.ans = ans;

        
        for(int a=1;a<=n-4;a++) {
            pw[0] = a;
            for(int b=a+1;b<=n-3;b++) {
                pw[1] = b;
                for(int c=b+1;c<=n-2;c++) {
                    pw[2] = c;
                    for(int d = c+1;d<=n-1;d++) {
                        pw[3] = d;
                        for(int e=d+1;e<=n;e++) {
                            pw[4] = e;
                            //검증
                            if(check()) answer++;
                        }
                    }
                }
            }
        }
        
        
        return answer;
    }
    
    public static boolean check() {
        
        Set<Integer> set = new HashSet<>();
        for(int n : pw ) set.add(n);
        
        for(int i=0;i<q.length;i++) {
            int checkNum = 0;
            
            for(int m : q[i]) {
                if(set.contains(m)) checkNum++;
            }
            
            if(ans[i] != checkNum) return false;
        }
        return true;
    }
}
