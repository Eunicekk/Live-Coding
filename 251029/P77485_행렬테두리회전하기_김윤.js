function solution(rows, columns, queries) {
    let index = 1;
    let array = Array.from({length: rows}, () => Array.from({length: columns}, () => index++));
    let result = [];
    
    queries.forEach((query) => {
        let [sr, sc, dr, dc] = query.map(value => value - 1);
        let start = array[sr][sc];
        let min = Infinity;
        
        // 상단 이동
        for (let r = sr; r < dr; r++) {
            let prev = array[r + 1][sc];
            array[r][sc] = prev;
            min = Math.min(min, array[r][sc]);
        }
        
        // 우측 이동
        for (let c = sc; c < dc; c++) {
            let prev = array[dr][c + 1];
            array[dr][c] = prev;
            min = Math.min(min, array[dr][c]);
        }
        
        // 하단 이동
        for (let r = dr; r > sr; r--) {
            let prev = array[r - 1][dc];
            array[r][dc] = prev;
            min = Math.min(min, array[r][dc]);
        }
        
        // 좌측 이동
        for (let c = dc; c > sc; c--) {
            if (c - 1 === sc) {
                array[sr][c] = start;
            } else {
                let prev = array[sr][c - 1];
                array[sr][c] = prev;
            }
            
            min = Math.min(min, array[sr][c]);
        }

        result.push(min);
    })
    
    return result;
}
