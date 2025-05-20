class Solution {
    public long solution(int k, int d) {

        long answer = 0;
        
        for(int i = 0; i <= d; i += k) {
            
            long max = (long) Math.sqrt((long)d * d - (long)i * i); //long타입까지 다 신경써주기
            answer += (max / k) + 1; //0까지 포함
        }
        
        return answer;
    }
}
