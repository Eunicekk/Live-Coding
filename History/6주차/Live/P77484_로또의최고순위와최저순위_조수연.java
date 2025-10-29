import java.util.*;

/**

테스트 1 〉	통과 (0.08ms, 81.4MB)
테스트 2 〉	통과 (0.06ms, 76.2MB)
테스트 3 〉	통과 (0.09ms, 75MB)
테스트 4 〉	통과 (0.06ms, 81.2MB)
테스트 5 〉	통과 (0.08ms, 72.9MB)
테스트 6 〉	통과 (0.11ms, 81.4MB)
테스트 7 〉	통과 (0.08ms, 85.4MB)
테스트 8 〉	통과 (0.08ms, 86MB)
테스트 9 〉	통과 (0.10ms, 84.6MB)
테스트 10 〉	통과 (0.10ms, 80.8MB)
테스트 11 〉	통과 (0.06ms, 87.5MB)
테스트 12 〉	통과 (0.08ms, 82MB)
테스트 13 〉	통과 (0.11ms, 79.9MB)
테스트 14 〉	통과 (0.08ms, 73.1MB)
테스트 15 〉	통과 (0.08ms, 82.9MB)

**/

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
    
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<6;i++) {
            set.add(win_nums[i]);
        }
        
        int zeroCnt = 0;
        for(int i=0;i<6;i++) {
            if(lottos[i] == 0) zeroCnt++;
            else set.remove(lottos[i]);
        }
        
        int max = set.size() + 1; // set에 6개 남아있을 때 처리 필요
        // zero 갯수에 따라..............
        // 0이 6개 => 숫자 3개 남았으면 최대 3개 더 맞힐 수 있음
        // 0이 1개 => 숫자 5개 남았으면 최대 1개
        int min = max - Math.min(zeroCnt, set.size());
        
        max = max == 7 ? 6 : max;        
        min = min == 7 ? 6 : min;
        
        int[] ans = {min, max};
        
        return ans;
    }
}
