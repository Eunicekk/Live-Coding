class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int ans = 0;
        
        cnt: for(int i=0;i < schedules.length;i++) {
            schedules[i] += 10;
            if(schedules[i]/10%10 >= 6) {
                schedules[i] += 40;
            }
            for(int j=0;j<7;j++) {
                if((j+startday)%7 == 6 || (j+startday)%7 == 0) continue;
                
                if(timelogs[i][j] > schedules[i]) {
                    // System.out.println(i+" "+j);
                    // System.out.println(timelogs[i][j]+" "+schedules[i]);
                    continue cnt;
                }
                
            }
            ans++;
        }
        
        
        return ans;
    }
}
