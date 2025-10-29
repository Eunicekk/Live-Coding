import java.util.*;

/**
  테스트 1 〉	통과 (0.33ms, 83.7MB)
  테스트 2 〉	통과 (0.33ms, 74.5MB)
  테스트 3 〉	통과 (0.38ms, 85.1MB)
  테스트 4 〉	통과 (0.37ms, 83.2MB)
  테스트 5 〉	통과 (0.33ms, 75.6MB)
  테스트 6 〉	통과 (2.11ms, 72.1MB)
  테스트 7 〉	통과 (0.33ms, 81.1MB)
  테스트 8 〉	통과 (1.46ms, 83.7MB)
  테스트 9 〉	통과 (1.75ms, 84.6MB)
  테스트 10 〉	통과 (1.99ms, 72.1MB)
  테스트 11 〉	통과 (2.66ms, 87.5MB)
  테스트 12 〉	통과 (1.53ms, 94.7MB)
  테스트 13 〉	통과 (1.53ms, 93.3MB)
  테스트 14 〉	통과 (1.58ms, 89.8MB)
  테스트 15 〉	통과 (114.05ms, 126MB)
  테스트 16 〉	통과 (108.50ms, 127MB)
  테스트 17 〉	통과 (161.70ms, 121MB)
  테스트 18 〉	통과 (129.39ms, 137MB)
  테스트 19 〉	통과 (160.03ms, 120MB)
  테스트 20 〉	통과 (142.61ms, 145MB)
  테스트 21 〉	통과 (126.72ms, 138MB)
*/

class Solution {
    static int[] diffs, times;
    static long limit;
    
    public int solution(int[] diffs, int[] times, long limit) {

        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        int[] arr = Arrays.copyOf(diffs, diffs.length); 
        Arrays.sort(arr);
        
        int start = arr[0], end = arr[arr.length-1];
        int answer = end;
        int level = 0;
        
        while(start <= end) {
            level = (start+end)/2;
            if(!getTime(level)) {
                start = level+1;
            } else {
                answer = level;
                end = level-1;
            }

        }
        
        // (diff[i] - level) * (times[i-1]+times[i])+times[i]

        
        return answer;
    }
    
    static boolean getTime(int level) {
        long time = diffs[0] - level > 0 ? times[0]*(diffs[0] - level) : times[0];
        
        
        for(int i=1;i<diffs.length;i++) {
            time += times[i];
            if(diffs[i] > level) {
                time += (times[i-1]+times[i])*(diffs[i] - level);
            }
            if(time > limit) return false;
        }
        return true;
    }
}
