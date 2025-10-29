class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        for(int i=1;i<land.length;i++) {
            for(int j=0;j<4;j++) {
                int sum = 0;
                for(int k=0;k<4;k++) {
                    if(k==j) continue;
                    sum = Math.max(sum, land[i-1][k]);
                }
                land[i][j] += sum;
            }
        }
        
        for(int j=0;j<4;j++) {
            answer = Math.max(answer, land[land.length-1][j]);
        }
        
        return answer;
    }
    
}
