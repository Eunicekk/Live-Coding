import java.util.*;

/*

    테스트 1 〉	통과 (0.07ms, 80MB)
    테스트 2 〉	통과 (0.05ms, 82.6MB)
    테스트 3 〉	통과 (0.04ms, 81.6MB)
    테스트 4 〉	통과 (0.04ms, 76.3MB)
    테스트 5 〉	통과 (0.07ms, 69.3MB)
    테스트 6 〉	통과 (0.04ms, 87.7MB)
    테스트 7 〉	통과 (0.04ms, 75.1MB)
    테스트 8 〉	통과 (0.06ms, 86.5MB)
    테스트 9 〉	통과 (0.06ms, 74.4MB)
    테스트 10 〉	통과 (0.04ms, 78.3MB)
    테스트 11 〉	통과 (0.04ms, 75.9MB)
    테스트 12 〉	통과 (0.04ms, 88.3MB)
    테스트 13 〉	통과 (0.05ms, 81.7MB)

*/
class Solution {
    static int num;
    static int ans = Integer.MAX_VALUE;
    public int solution(int storey) {
        num = storey;
        
        // 16 -> (+10) * 2 + (-1) * 4
        // 2554 -> (+1000) * 2 + (100) * 5 + (10) * 5 + (1) * 4
        
        // 6876 ->
        // 1000 * 6 + 100 * 8 + 10 * 7 + 1 * 6
        // 1000 * 6 + 100 * 8 + 10 * 8 + -1 * 4
        // 1000 * 6 + 100 * (8+1) + -10 * 3 + 1 * 6
        // 1000 * 6 + 100 * (8+1) + -10 * 2 + -1 * 4
        
        // 1000 * 7 + -100 * 2 + 10 * 7 + 1 * 6
        // 1 * 6 + -10 * 3 + -100 * 1 + 1000 * 7
        
        // 바꾸고 싶은 자리수를 10에서 빼고, 그 앞 1 올리기.
        

        dfs(1, num, 0);
        
        return ans;
    }
    
    static void dfs(int dep, int number, int cnt) {
        
        // 이미 ans보다 크다면 끝내기
        if(cnt >= ans) return;
        
        if(number == 0) {
            ans = Math.min(ans, cnt);
            return;
        }

        // 양수
        dfs(dep+1, number/10, cnt + number % 10);

        // 음수
        dfs(dep+1, number/10+1, cnt + (int) (10 - number%10));

        
    }
    
}
