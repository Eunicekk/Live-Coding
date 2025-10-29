import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Integer> book = new PriorityQueue<>();
        int l = book_time.length;
        for(int i=0; i<l; i++){
            String[] nowBook = book_time[i];
            int a = getTime(nowBook[0]);
            int b = getTime(nowBook[1]);
            book.add(a*10+1);
            book.add(b*10+100);
        }
        int room = 0;
        while(!book.isEmpty()){
            int tmp = book.poll();
            if(tmp%10==1){
                room++;
                answer = Math.max(room, answer);
            }else{
                room--;
            }
        }
        return answer;
    }
    int getTime(String time){
        int ret;
        int h1 = time.charAt(0)-'0';
        int h2 = time.charAt(1)-'0';
        int m1 = time.charAt(3)-'0';
        int m2 = time.charAt(4)-'0';
        ret = h1*600+h2*60+m1*10+m2;
        return ret;
    }
}
