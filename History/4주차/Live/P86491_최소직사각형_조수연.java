import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int w = Integer.MIN_VALUE,
        h = Integer.MIN_VALUE;
        
        for(int i=0;i<sizes.length;i++) {
            Arrays.sort(sizes[i]);
            w = Math.max(w, sizes[i][0]);
            h = Math.max(h, sizes[i][1]);
        }
        
        return w * h;
    }
}
