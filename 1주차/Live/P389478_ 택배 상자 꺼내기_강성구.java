class Solution {
    public int solution(int n, int w, int num) {//22, 6, 8, 4, 12 
        int answer = 1;
        int height = ((num-1)/w) +1;        //해당 상자가 있는 높이
        int remain = w - num%w;         //해당 상자 층을 채우기 위해 더 필요한 박스(위치)
        if(num%w==0)remain = 0;
        n -= height*w;                  //해당 층 위에 쌓일 박스들
        int w2 = w*2;                   //왔다갔다 기준 두 층
        answer += (n/w2) *2;
        n = n%w2;
        if(n>remain) answer++;
        if(n>=w2-remain)answer++;
        return answer;
    }
}
