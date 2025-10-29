class Solution {
	public int solution(int[] schedules, int[][] timelogs, int startday) {
		int answer = 0;
		int day = startday;
		int[] newsch = new int[schedules.length];
		for (int i = 0; i < schedules.length; i++) {
			int tmp = schedules[i] + 10;
			if (tmp % 100 >= 60) {
				newsch[i] = tmp + 40;
			} else {
				newsch[i] = tmp;
			}
		}
		out: for (int i = 0; i < schedules.length; i++) {
			day = startday;
			for (int j = 0; j < timelogs[i].length; j++) {
				day++;
				if (day == 8)
					day = 1;
		
				if (day >=2 && day <= 6) {
					if (timelogs[i][j] > newsch[i]) {
						continue out;
					}
				}
				if (j == timelogs[i].length - 1)
					answer++;
			}
		}
		return answer;
	}
}

//채점을 시작합니다.
//정확성  테스트
//테스트 1 〉	통과 (0.01ms, 91.1MB)
//테스트 2 〉	통과 (0.02ms, 82.9MB)
//테스트 3 〉	통과 (0.01ms, 85.9MB)
//테스트 4 〉	통과 (0.01ms, 83MB)
//테스트 5 〉	통과 (0.01ms, 72.5MB)
//테스트 6 〉	통과 (0.01ms, 90MB)
//테스트 7 〉	통과 (0.33ms, 93.3MB)
//테스트 8 〉	통과 (0.55ms, 83.7MB)
//테스트 9 〉	통과 (0.53ms, 85.2MB)
//테스트 10 〉	통과 (0.32ms, 83.5MB)
//테스트 11 〉	통과 (0.35ms, 78.5MB)
//테스트 12 〉	통과 (0.35ms, 92.1MB)
//테스트 13 〉	통과 (0.41ms, 81.4MB)
//테스트 14 〉	통과 (0.60ms, 93.1MB)
//테스트 15 〉	통과 (0.55ms, 85.6MB)
//테스트 16 〉	통과 (0.36ms, 80.5MB)
//테스트 17 〉	통과 (0.62ms, 78.2MB)
//테스트 18 〉	통과 (0.69ms, 94.1MB)
//테스트 19 〉	통과 (0.35ms, 79.1MB)
//테스트 20 〉	통과 (0.32ms, 92.1MB)
//테스트 21 〉	통과 (0.33ms, 97.9MB)
//테스트 22 〉	통과 (0.35ms, 91.2MB)
//테스트 23 〉	통과 (0.39ms, 87.5MB)
//테스트 24 〉	통과 (0.69ms, 78.5MB)
//테스트 25 〉	통과 (0.02ms, 76.5MB)
//테스트 26 〉	통과 (0.03ms, 91.9MB)
//테스트 27 〉	통과 (0.02ms, 88.4MB)
//테스트 28 〉	통과 (0.31ms, 96.5MB)
//테스트 29 〉	통과 (0.18ms, 91.8MB)
//테스트 30 〉	통과 (0.15ms, 75.4MB)
//테스트 31 〉	통과 (0.19ms, 84.8MB)
//테스트 32 〉	통과 (0.17ms, 87MB)
//테스트 33 〉	통과 (0.34ms, 91.7MB)
//테스트 34 〉	통과 (0.36ms, 81.6MB)
//테스트 35 〉	통과 (0.38ms, 87.9MB)
//테스트 36 〉	통과 (0.37ms, 85.2MB)
//테스트 37 〉	통과 (0.22ms, 72.7MB)
//테스트 38 〉	통과 (0.17ms, 72.5MB)
//테스트 39 〉	통과 (0.39ms, 94.6MB)
//테스트 40 〉	통과 (0.38ms, 88.9MB)
//테스트 41 〉	통과 (0.39ms, 80.5MB)
//테스트 42 〉	통과 (0.33ms, 93MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0