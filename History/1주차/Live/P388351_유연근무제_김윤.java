class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        int[] count = new int[n];
        
        for (int i = 0; i < n; i++) {
            int want_hour = schedules[i] / 100;
            int want_min = schedules[i] % 100;
            
            if (want_min + 10 >= 60) {
                want_hour++;
                want_min = (want_min + 10) % 60;
            } else {
                want_min += 10;
            }
            
            for (int j = startday; j < startday + 7; j++) {
                if (j % 7 == 6 || j % 7 == 0) continue;
                
                int real_hour = timelogs[i][j-startday] / 100;
                int real_min = timelogs[i][j-startday] % 100;
                
                if ((real_hour < want_hour) || (real_hour == want_hour && real_min <= want_min)) {
                    count[i]++;
                }
                
                if (count[i] == 5) answer++;
            }
        }
        
        return answer;
    }
}
