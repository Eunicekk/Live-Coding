function solution(topping) {
    let result = 0;
    let n = topping.length;
    let left = Array(n).fill(0);
    let right = Array(n).fill(0);
    let leftSet = new Set();
    let rightSet = new Set();
    
    for (let i = 0; i < n; i++) {
        leftSet.add(topping[i]);
        left[i] = leftSet.size;
    }
    
    for (let i = n-1; i >= 0; i--) {
        rightSet.add(topping[i]);
        right[i] = rightSet.size;
    }
    
    for (let i = 0; i < n-1; i++) {
        if (left[i] === right[i+1]) {
            result++;
        }
    }
    
    return result;
}

// 테스트 1 〉	통과 (26.21ms, 37MB)
// 테스트 2 〉	통과 (29.37ms, 41MB)
// 테스트 3 〉	통과 (30.08ms, 39.7MB)
// 테스트 4 〉	통과 (34.90ms, 39.4MB)
// 테스트 5 〉	통과 (71.16ms, 76.6MB)
// 테스트 6 〉	통과 (77.24ms, 81MB)
// 테스트 7 〉	통과 (93.82ms, 81MB)
// 테스트 8 〉	통과 (73.17ms, 80.9MB)
// 테스트 9 〉	통과 (77.57ms, 80.9MB)
// 테스트 10 〉	통과 (76.96ms, 80.9MB)
// 테스트 11 〉	통과 (11.06ms, 39.5MB)
// 테스트 12 〉	통과 (4.02ms, 38.1MB)
// 테스트 13 〉	통과 (81.63ms, 80.9MB)
// 테스트 14 〉	통과 (67.13ms, 79.2MB)
// 테스트 15 〉	통과 (76.15ms, 79.2MB)
// 테스트 16 〉	통과 (74.26ms, 79.1MB)
// 테스트 17 〉	통과 (69.84ms, 79.2MB)
// 테스트 18 〉	통과 (72.71ms, 79.3MB)
// 테스트 19 〉	통과 (71.77ms, 79.3MB)
// 테스트 20 〉	통과 (84.49ms, 79.3MB)
