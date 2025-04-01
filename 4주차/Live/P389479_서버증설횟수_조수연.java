import java.util.*;

class Solution {
    
    public int solution(int[] players, int m, int k) {
        int ans = 0;
        
        // 0~m-1 명 까지는 서버 필요 X
        // k 시간 대여
        // n명일 때, 서버는 n/m개 필요
        
        int 현재켜져있는서버 = 0;
        
        // 1 1 2 2 1 2 , k = 3;
        // + . + + . +
        
        int[] 킨서버 = new int[24];
        
        for(int i=0;i<24;i++) {
            players[i] /= m;
            
            if(i-k >= 0 && 킨서버[i-k] != 0) {
                현재켜져있는서버 -= 킨서버[i-k];
            }
            
            if(players[i] > 현재켜져있는서버) {
                킨서버[i] += players[i] - 현재켜져있는서버;
                ans += 킨서버[i];
                현재켜져있는서버 = players[i];
            }
        }
        
        return ans;
    }
}
