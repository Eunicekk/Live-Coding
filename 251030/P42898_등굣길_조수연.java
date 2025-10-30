class Solution {
    static int MOD = 1_000_000_007;
    static int n, m, puddles[][];
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        this.n = n;
        this.m = m;
        this.puddles = puddles;
        
        boolean[][] puddle = new boolean[n][m];
        long[][] dp = new long[n][m];
        dp[0][0] = 1;
        
        for(int[] p : puddles) {
            puddle[p[1]-1][p[0]-1] = true;
        }
        
        // bottom - up
        for(int i=0;i<n;i++) {
            for(int j =0;j<m;j++) {
                
                if(i==0 && j==0) continue;
                
                if(puddle[i][j]) dp[i][j] = 0;
                else {
                    long top = i-1 < 0 ? 0 : dp[i-1][j];
                    long left = j-1 < 0 ? 0 : dp[i][j-1];
                    dp[i][j] = (top + left)%MOD;
                }
                // System.out.println("i: "+i+", j: "+j+", dp[i][j]: "+dp[i][j]);
            }
        }
        
        return (int) dp[n-1][m-1]%MOD;
    }

}

/**
정확성  테스트
테스트 1 〉	통과 (0.04ms, 86.1MB)
테스트 2 〉	통과 (0.02ms, 92.7MB)
테스트 3 〉	통과 (0.03ms, 84.8MB)
테스트 4 〉	통과 (0.05ms, 79.9MB)
테스트 5 〉	통과 (0.04ms, 72.7MB)
테스트 6 〉	통과 (0.07ms, 83.9MB)
테스트 7 〉	통과 (0.04ms, 80.3MB)
테스트 8 〉	통과 (0.07ms, 74.1MB)
테스트 9 〉	통과 (0.03ms, 74.4MB)
테스트 10 〉	통과 (0.02ms, 85.2MB)
효율성  테스트
테스트 1 〉	통과 (0.90ms, 54.2MB)
테스트 2 〉	통과 (0.37ms, 53.7MB)
테스트 3 〉	통과 (0.46ms, 72MB)
테스트 4 〉	통과 (0.42ms, 53.9MB)
테스트 5 〉	통과 (0.60ms, 53.9MB)
테스트 6 〉	통과 (0.82ms, 54.1MB)
테스트 7 〉	통과 (0.39ms, 53.8MB)
테스트 8 〉	통과 (0.68ms, 70.7MB)
테스트 9 〉	통과 (0.40ms, 53.3MB)
테스트 10 〉	통과 (0.39ms, 53.9MB)
**/
