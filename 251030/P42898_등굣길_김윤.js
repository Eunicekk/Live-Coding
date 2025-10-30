function solution(m, n, puddles) {
    const NUMBER = 1_000_000_007;
    let dp = Array.from({length: n}, () => Array(m).fill(0));
    let check = Array.from({length: n}, () => Array(m).fill(false));
    
    puddles.forEach((puddle) => {
        let [a, b] = puddle;
        check[b - 1][a - 1] = true;
    })
    
    for (let r = 0; r < n; r++) {
        if (check[r][0]) {
            break;
        }
        
        dp[r][0] = 1;
    }
    
    for (let c = 0; c < m; c++) {
        if (check[0][c]) {
            break;
        }
        
        dp[0][c] = 1;
    }
    
    for (let r = 1; r < n; r++) {
        out: for (let c = 1; c < m; c++) {
            if (check[r][c]) {
                continue out;   
            }
            
            dp[r][c] = (dp[r][c - 1] + dp[r - 1][c]) % NUMBER;
        }
    }
    
    return dp[n - 1][m - 1];
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.14ms, 33.4MB)
// 테스트 2 〉	통과 (0.16ms, 33.4MB)
// 테스트 3 〉	통과 (0.23ms, 33.5MB)
// 테스트 4 〉	통과 (0.23ms, 33.5MB)
// 테스트 5 〉	통과 (0.41ms, 33.4MB)
// 테스트 6 〉	통과 (0.25ms, 33.5MB)
// 테스트 7 〉	통과 (0.23ms, 33.4MB)
// 테스트 8 〉	통과 (0.26ms, 33.4MB)
// 테스트 9 〉	통과 (0.29ms, 33.4MB)
// 테스트 10 〉	통과 (0.22ms, 33.4MB)
// 효율성  테스트
// 테스트 1 〉	통과 (1.01ms, 33.5MB)
// 테스트 2 〉	통과 (0.62ms, 33.5MB)
// 테스트 3 〉	통과 (0.65ms, 33.4MB)
// 테스트 4 〉	통과 (0.90ms, 33.5MB)
// 테스트 5 〉	통과 (0.90ms, 33.4MB)
// 테스트 6 〉	통과 (0.99ms, 33.5MB)
// 테스트 7 〉	통과 (0.65ms, 33.5MB)
// 테스트 8 〉	통과 (0.83ms, 33.4MB)
// 테스트 9 〉	통과 (0.91ms, 33.6MB)
// 테스트 10 〉	통과 (0.99ms, 33.5MB)
