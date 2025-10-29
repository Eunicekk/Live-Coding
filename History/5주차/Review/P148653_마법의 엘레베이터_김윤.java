class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int last = storey % 10;
            int next = (storey / 10) % 10;
            
            if (last > 5) {
                storey += (10 - last);
                answer += (10 - last);
            } else if (last < 5) {
                storey -= last;
                answer += last;
            } else {
                if (next >= 5) {
                    storey += (10 - last);  // 올림
                    answer += (10 - last);
                } else {
                    storey -= last;  // 내림
                    answer += last;
                }
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}
