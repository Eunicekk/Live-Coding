import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[] server = new int[24];
        int answer = 0;

        for (int i = 0; i < 24; i++) {
            if (players[i] / m > 0) {
                int value = players[i] / m;
                answer += value;
                
                if (i + k < 24) {
                    for (int j = i; j < i + k; j++) {
                        server[j] += value;
                        players[j] -= value * m;
                    }
                } else {
                    for (int j = i; j < 24; j++) {
                        server[j] += value;
                        players[j] -= value * m;
                    }
                }
            }
        }
        return answer;
    }
}
