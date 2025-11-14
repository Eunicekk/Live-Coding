function solution(genres, plays) {
    let result = [];
    let songs = new Map();
    let count = new Map();
    let length = genres.length;

    for (let i = 0; i < length; i++) {
        count.set(genres[i], count.has(genres[i]) ? count.get(genres[i]) + plays[i] : plays[i]);
    }
    
    const sortByCount = [...count].sort((a, b) => b[1] - a[1]);
    
    for (let [genre] of sortByCount) {
        songs.set(genre, []);
    }
    
    for (let i = 0; i < length; i++) {
        songs.get(genres[i]).push([plays[i], i]);
    }
    
    for (let [genre] of sortByCount) {
        let song = songs.get(genre);
        
        song.sort((a, b) => {
            if (a[0] !== b[0]) return b[0] - a[0];
            return a[1] - b[1];
        })
        
        result.push(song[0][1]);

        if (song.length >= 2) {
            result.push(song[1][1]);
        }
    }

    return result;
}

// 테스트 1 〉	통과 (0.14ms, 33.5MB)
// 테스트 2 〉	통과 (0.13ms, 33.4MB)
// 테스트 3 〉	통과 (0.12ms, 33.5MB)
// 테스트 4 〉	통과 (0.10ms, 33.6MB)
// 테스트 5 〉	통과 (0.33ms, 33.5MB)
// 테스트 6 〉	통과 (0.34ms, 33.5MB)
// 테스트 7 〉	통과 (0.31ms, 33.4MB)
// 테스트 8 〉	통과 (0.31ms, 33.5MB)
// 테스트 9 〉	통과 (0.13ms, 33.5MB)
// 테스트 10 〉	통과 (0.34ms, 33.5MB)
// 테스트 11 〉	통과 (0.15ms, 33.4MB)
// 테스트 12 〉	통과 (0.31ms, 33.6MB)
// 테스트 13 〉	통과 (0.39ms, 33.5MB)
// 테스트 14 〉	통과 (0.53ms, 33.5MB)
// 테스트 15 〉	통과 (0.13ms, 33.5MB)
