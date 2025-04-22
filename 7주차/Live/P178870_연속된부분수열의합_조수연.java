import java.util.*;

/**
  테스트 1 〉	통과 (0.02ms, 73.7MB)
  테스트 2 〉	통과 (0.02ms, 81.8MB)
  테스트 3 〉	통과 (0.02ms, 93MB)
  테스트 4 〉	통과 (0.08ms, 73.3MB)
  테스트 5 〉	통과 (0.68ms, 97.1MB)
  테스트 6 〉	통과 (0.92ms, 78.1MB)
  테스트 7 〉	통과 (1.79ms, 88.4MB)
  테스트 8 〉	통과 (2.52ms, 77.9MB)
  테스트 9 〉	통과 (12.39ms, 86.3MB)
  테스트 10 〉	통과 (11.06ms, 133MB)
  테스트 11 〉	통과 (12.38ms, 126MB)
  테스트 12 〉	통과 (10.15ms, 124MB)
  테스트 13 〉	통과 (19.70ms, 122MB)
  테스트 14 〉	통과 (14.05ms, 139MB)
  테스트 15 〉	통과 (14.80ms, 137MB)
  테스트 16 〉	통과 (6.80ms, 140MB)
  테스트 17 〉	통과 (8.43ms, 121MB)
  테스트 18 〉	통과 (0.01ms, 73.3MB)
  테스트 19 〉	통과 (0.02ms, 76.4MB)
  테스트 20 〉	통과 (0.02ms, 92.6MB)
  테스트 21 〉	통과 (0.02ms, 86.7MB)
  테스트 22 〉	통과 (0.02ms, 72.6MB)
  테스트 23 〉	통과 (0.02ms, 73.3MB)
  테스트 24 〉	통과 (8.87ms, 129MB)
  테스트 25 〉	통과 (5.05ms, 122MB)
  테스트 26 〉	통과 (6.71ms, 124MB)
  테스트 27 〉	통과 (6.67ms, 143MB)
  테스트 28 〉	통과 (9.39ms, 124MB)
  테스트 29 〉	통과 (9.20ms, 144MB)
  테스트 30 〉	통과 (10.53ms, 128MB)
  테스트 31 〉	통과 (0.01ms, 85.3MB)
  테스트 32 〉	통과 (0.01ms, 69.4MB)
  테스트 33 〉	통과 (0.01ms, 79.3MB)
  테스트 34 〉	통과 (0.02ms, 73.2MB)
**/

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int length = Integer.MAX_VALUE;
        int startIdx = -1, endIdx = -1;
        
        int start = 0, end = 0, sum = 0;
        
        while(end < sequence.length) {
            sum += sequence[end++];
            
            while(sum > k && start < end) {
                sum -= sequence[start++];
            }
            
            if(sum == k && length > end - start) {
                length = end - start;
                startIdx = start;
                endIdx = end-1;
            }
            
            
        }
        
        return new int[]{startIdx, endIdx};
    }
}
