
import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < ingredient.length; i++){
            s.push(ingredient[i]);
            if(s.size() >= 4){
            int a = s.pop();
            int b = s.pop();
            int c = s.pop();
            int d = s.pop();
            if(a == 1 && b == 3 && c == 2 && d==1){
                answer++;
            }else{
                 s.push(d);
                 s.push(c);
                 s.push(b);
                 s.push(a);
            }
            }
        }
        return answer;
    }
}

// 테스트 1 〉	통과 (0.12ms, 82.8MB)
// 테스트 2 〉	통과 (0.19ms, 101MB)
// 테스트 3 〉	통과 (107.23ms, 99.6MB)
// 테스트 4 〉	통과 (119.93ms, 126MB)
// 테스트 5 〉	통과 (133.33ms, 135MB)
// 테스트 6 〉	통과 (92.31ms, 111MB)
// 테스트 7 〉	통과 (111.47ms, 123MB)
// 테스트 8 〉	통과 (122.79ms, 102MB)
// 테스트 9 〉	통과 (85.60ms, 115MB)
// 테스트 10 〉	통과 (5.50ms, 73.2MB)
// 테스트 11 〉	통과 (74.24ms, 114MB)
// 테스트 12 〉	통과 (139.76ms, 135MB)
// 테스트 13 〉	통과 (0.12ms, 82.3MB)
// 테스트 14 〉	통과 (0.13ms, 80.9MB)
// 테스트 15 〉	통과 (0.12ms, 85.7MB)
// 테스트 16 〉	통과 (0.16ms, 95MB)
// 테스트 17 〉	통과 (0.16ms, 83.1MB)
// 테스트 18 〉	통과 (0.21ms, 85.7MB)
// 채점 결과
// 정확성: 100.0
// 합계: 100.0 / 100.0