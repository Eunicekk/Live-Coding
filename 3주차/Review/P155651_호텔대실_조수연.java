import java.util.*;

class Solution {
    static class Time {
        int startTime, endTime;
        
        Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue<Time> pq = new PriorityQueue<>((a, b) -> (a.startTime - b.startTime));
        
        for(int i=0;i<book_time.length;i++) {
            String[] in = book_time[i][0].split(":");            
            int startTime = Integer.parseInt(in[0])*100 + Integer.parseInt(in[1]);
            
            in = book_time[i][1].split(":");
            int endTime = Integer.parseInt(in[0])*100 + Integer.parseInt(in[1])+10;
            
            if(endTime % 100 >= 60) {
                endTime += 40;
            }
            pq.offer(new Time(startTime, endTime));
        }
        
        TreeSet<Integer> ts = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        
        w: while(!pq.isEmpty()) {
            Time t = pq.poll();
            
            for(int i=0;i<list.size();i++) {
                if(list.get(i)<= t.startTime) {
                    System.out.println(t.startTime);
                    list.remove(i);
                    list.add(t.endTime);
                    continue w;
                }
            }
            
            list.add(t.endTime);
            System.out.println(list.size());

        }
        
        return list.size();
    }
}
