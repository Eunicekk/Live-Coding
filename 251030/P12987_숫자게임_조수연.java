import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        for(int i=0;i<A.length;i++) {
            pqA.add(A[i]);
        }
        // 1 3 5 7
        
        PriorityQueue<Integer> pqB = new PriorityQueue<>();
        for(int i=0;i<B.length;i++) {
            pqB.add(B[i]);
        }        
        
        // 2 2 6 8
        
        int i = 0;
        while(!pqB.isEmpty()) {
            int aa = pqA.poll();
            while(!pqB.isEmpty() && pqB.peek() <= aa) {
                pqB.poll();
            }
            if(pqB.isEmpty()) return answer;
            else {
                pqB.poll();
                answer++;
            }
        }
        
        return answer;
    }
}

/**
정확성  테스트
테스트 1 〉	통과 (0.63ms, 75.6MB)
테스트 2 〉	통과 (0.62ms, 85.3MB)
테스트 3 〉	통과 (0.70ms, 85.8MB)
테스트 4 〉	통과 (0.65ms, 82.8MB)
테스트 5 〉	통과 (0.93ms, 85.9MB)
테스트 6 〉	통과 (1.57ms, 82MB)
테스트 7 〉	통과 (1.11ms, 85.5MB)
테스트 8 〉	통과 (1.07ms, 69MB)
테스트 9 〉	통과 (2.50ms, 81.2MB)
테스트 10 〉	통과 (2.51ms, 77MB)
테스트 11 〉	통과 (2.93ms, 88MB)
테스트 12 〉	통과 (2.55ms, 78.3MB)
테스트 13 〉	통과 (8.76ms, 77.3MB)
테스트 14 〉	통과 (22.72ms, 92.1MB)
테스트 15 〉	통과 (10.69ms, 89.4MB)
테스트 16 〉	통과 (17.84ms, 90.6MB)
테스트 17 〉	통과 (3.24ms, 78.7MB)
테스트 18 〉	통과 (2.85ms, 88MB)
효율성  테스트
테스트 1 〉	통과 (154.80ms, 76.8MB)
테스트 2 〉	통과 (188.46ms, 71.6MB)
테스트 3 〉	통과 (183.01ms, 91.4MB)
**/
