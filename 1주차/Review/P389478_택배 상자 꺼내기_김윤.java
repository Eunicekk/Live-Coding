class Solution {
    public int solution(int n, int w, int num) {
        // 1. num이 위치한 층(row)과 열(col) 계산
        int row = (num - 1) / w;
        int col = (num - 1) % w;
        
        // 홀수 층인 경우 열 위치 반전
        if (row % 2 == 1) {
            col = w - 1 - col;
        }
        
        // 2. 총 층 수 계산
        int totalRows = (n + w - 1) / w;
        
        // 3. num 상자 위에 있는 상자 수 계산
        int count = 1; // 자기 자신 포함
        
        // 위층들을 순회하며 같은 열에 있는 상자들 계산
        for (int r = row + 1; r < totalRows; r++) {
            // 현재 층에서 상자의 수 계산 (마지막 층은 w개보다 적을 수 있음)
            int boxesInCurrentRow = (r == totalRows - 1) ? Math.min(w, n - (totalRows - 1) * w) : w;
            
            // 현재 열 위치 계산 (홀짝에 따라 방향이 달라짐)
            int currentCol = (r % 2 == 0) ? col : (w - 1 - col);
            
            // 현재 열 위치가 유효한지 확인
            if (currentCol < boxesInCurrentRow) {
                count++;
            }
        }
        
        return count;
    }
}
