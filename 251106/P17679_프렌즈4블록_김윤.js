function solution(m, n, board) {
    let array = [];
    let set = new Set();
    let result = 0;
    
    for (let i = 0; i < m; i++) {
        array.push(board[i].split(""));
    }
    
    while (true) {
        for (let r = 0; r < m-1; r++) {
            for (let c = 0; c < n-1; c++) {
                let rule = array[r][c];

                if (rule === '0') {
                    continue;
                }

                if (rule === array[r+1][c] && rule === array[r][c+1] && rule === array[r+1][c+1]) {
                    set.add([r, c]);
                }
            }
        }

        if (set.size === 0) {
            break;
        }

        for (let [r, c] of set) {
            array[r][c] = '0';
            array[r+1][c] = '0';
            array[r][c+1] = '0';
            array[r+1][c+1] = '0';
        }
        
        set.clear();

        for (let c = 0; c < n; c++) {
            for (let r = m - 1; r >= 0; r--) {
                if (array[r][c] === '0') {
                    for (let k = r - 1; k >= 0; k--) {
                        if (array[k][c] !== '0') {
                            array[r][c] = array[k][c];
                            array[k][c] = '0';
                            break;
                        }
                    }
                }
            }
        }
    }
    
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (array[i][j] === '0') {
                result++;
            }
        }
    }
    
    return result;
}

// 테스트 1 〉	통과 (0.25ms, 33.5MB)
// 테스트 2 〉	통과 (0.28ms, 33.5MB)
// 테스트 3 〉	통과 (0.11ms, 33.5MB)
// 테스트 4 〉	통과 (1.30ms, 33.7MB)
// 테스트 5 〉	통과 (22.92ms, 37.6MB)
// 테스트 6 〉	통과 (13.35ms, 37.9MB)
// 테스트 7 〉	통과 (0.68ms, 33.6MB)
// 테스트 8 〉	통과 (1.21ms, 33.7MB)
// 테스트 9 〉	통과 (0.25ms, 33.5MB)
// 테스트 10 〉	통과 (0.97ms, 33.5MB)
// 테스트 11 〉	통과 (2.02ms, 33.7MB)
