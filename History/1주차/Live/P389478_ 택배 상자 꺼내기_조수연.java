class Solution {
    public int solution(int n, int w, int num) {
        
        int h = n % w == 0 ? n/w : n/w + 1;
        
        //갯수...
        // n=3;
        // w=1;
        // num = 3;
/**
36 35 34 33 32 31
25 26 27 28 29 30
24 23 22 21 20 19
13 14 15 16 17 18
12 11 10 9  8  7     1 3 5 7 9 11 흐음. . . .
1  2  3  4  5  6
**/
    
        int answer = 1;
        int i = 1;
        int last = num;
        while(num + w * 2 * i <= n) {
            answer += 2;
            last = num + w * 2 * i;
            System.out.println(last);
            i++;
        }
        
        int x = last % w;
        int y = last / w;
        System.out.println(x+" "+y);
        
        if(x == 0) {
            if(last + 1 <= n) {
                answer++;
            }
        } else {
            if(last + (w - x)*2+1 <= n) {
                // System.out.println(answer);
                answer++;
            } 
        }
        
        // System.out.print(last+" "+x+" "+y);
        return answer;
    }
}
