class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;           //직원수
        // 1 -> 5,6
        // 2-> 4,5
        // 3-> 3,4
        // 6-> 0,1
        // 7-> 0,6
        //j+startday %7이 0이나 6이면 무시
        for(int emp=0; emp<n; emp++){
            boolean can = true;
            int time = calculate(schedules[emp]);
            time+=10;
            int[] schedule = timelogs[emp];
            for(int i=0; i<7; i++){
                int mod = (i+startday)%7;
                if(mod==0 || mod==6) continue;
                int nowTime = calculate(schedule[i]);
                if(nowTime>time){
                    can = false;
                    break;
                }
            }
            if(can)answer++;
        }
        return answer;
    }
    private int calculate(int input){
        int hour = input/100;
        int minute = input%100;
        return 60*hour+minute;
    }
}
