import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[10000001];
        for(int i = 0; i < tangerine.length;i++){
          arr[tangerine[i]]++;
            if(!list.contains(tangerine[i])){
                list.add(tangerine[i]);
            }
        }
         List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            list2.add(arr[list.get(i)]);
        }
       Collections.sort(list2);
       int si = list2.size()-1;
        for(int i = si; i>= 0; i--){
            k -= list2.get(i);
            if(k <= 0){
                break;
            }
            answer++;
        }
        return answer;
    }
}

//테스트 1 〉	통과 (79.81ms, 120MB)
//테스트 2 〉	통과 (127.46ms, 120MB)
//테스트 3 〉	통과 (88.76ms, 136MB)
//테스트 4 〉	통과 (49.90ms, 134MB)
//테스트 5 〉	통과 (43.42ms, 131MB)
//테스트 6 〉	통과 (59.59ms, 130MB)
//테스트 7 〉	통과 (39.47ms, 138MB)
//테스트 8 〉	통과 (37.09ms, 128MB)
//테스트 9 〉	통과 (37.72ms, 126MB)
//테스트 10 〉	통과 (47.02ms, 125MB)
//테스트 11 〉	통과 (21.42ms, 113MB)
//테스트 12 〉	통과 (22.61ms, 130MB)
//테스트 13 〉	통과 (21.32ms, 123MB)
//테스트 14 〉	통과 (21.28ms, 120MB)
//테스트 15 〉	통과 (23.44ms, 125MB)
//테스트 16 〉	통과 (30.04ms, 126MB)
//테스트 17 〉	통과 (22.93ms, 117MB)
//테스트 18 〉	통과 (20.65ms, 117MB)
//테스트 19 〉	통과 (20.77ms, 131MB)
//테스트 20 〉	통과 (25.94ms, 125MB)
//테스트 21 〉	통과 (25.24ms, 115MB)
//테스트 22 〉	통과 (24.65ms, 111MB)
//테스트 23 〉	통과 (27.76ms, 122MB)
//테스트 24 〉	통과 (29.60ms, 123MB)
//테스트 25 〉	통과 (112.59ms, 133MB)
//테스트 26 〉	통과 (277.81ms, 119MB)
//테스트 27 〉	통과 (7097.13ms, 134MB)
//테스트 28 〉	통과 (3072.67ms, 132MB)
//테스트 29 〉	통과 (3873.24ms, 136MB)
//테스트 30 〉	통과 (7206.15ms, 123MB)
//테스트 31 〉	통과 (54.67ms, 138MB)
//테스트 32 〉	통과 (128.59ms, 136MB)
//테스트 33 〉	통과 (5220.65ms, 124MB)
//테스트 34 〉	통과 (3775.28ms, 130MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0