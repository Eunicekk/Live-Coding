class Solution {
	public int solution(int n, int w, int num) {
		int answer = 0;
		int newnum = --num;
		int newn = --n;
		int numPos = newnum / w % 2 == 1 ? w - newnum % w - 1 : newnum % w;
		boolean topDir = newn / w % 2 == 1 ? true : false;
		int topPos = newn / w % 2 == 1 ? w - newn % w - 1 : newn % w;
		int count = newn / w - newnum / w;
		int minusornot = 0;
		if (topDir) {
			if (topPos > numPos)
				minusornot = -1;
		} else {
			if (topPos < numPos)
				minusornot = -1;
		}
		answer = count + minusornot +1;
		return answer;
	}
}

//테스트 1 〉	통과 (0.02ms, 85.1MB)
//테스트 2 〉	통과 (0.02ms, 79.1MB)
//테스트 3 〉	통과 (0.02ms, 70.5MB)
//테스트 4 〉	통과 (0.02ms, 89.5MB)
//테스트 5 〉	통과 (0.02ms, 79.5MB)
//테스트 6 〉	통과 (0.02ms, 78MB)
//테스트 7 〉	통과 (0.02ms, 75.3MB)
//테스트 8 〉	통과 (0.02ms, 70.4MB)
//테스트 9 〉	통과 (0.03ms, 82.7MB)
//테스트 10 〉	통과 (0.01ms, 72.4MB)
//테스트 11 〉	통과 (0.02ms, 76.2MB)
//테스트 12 〉	통과 (0.01ms, 73.3MB)
//테스트 13 〉	통과 (0.01ms, 69.6MB)
//테스트 14 〉	통과 (0.01ms, 81.9MB)
//테스트 15 〉	통과 (0.01ms, 76.1MB)
//테스트 16 〉	통과 (0.01ms, 92.1MB)
//테스트 17 〉	통과 (0.02ms, 71MB)
//테스트 18 〉	통과 (0.02ms, 78.2MB)
//테스트 19 〉	통과 (0.01ms, 79.3MB)
//테스트 20 〉	통과 (0.01ms, 82.9MB)
//테스트 21 〉	통과 (0.01ms, 68.1MB)
//테스트 22 〉	통과 (0.02ms, 70.4MB)
//테스트 23 〉	통과 (0.01ms, 78.5MB)
//테스트 24 〉	통과 (0.02ms, 81.6MB)
//테스트 25 〉	통과 (0.01ms, 79.9MB)

//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0