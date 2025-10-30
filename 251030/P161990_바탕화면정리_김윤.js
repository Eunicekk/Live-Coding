function solution(wallpaper) {
    let array = wallpaper.map((value) => value.split(""));
    let [minR, minC, maxR, maxC] = [Infinity, Infinity, -Infinity, -Infinity];
    
    for (let r = 0; r < array.length; r++) {
        for (let c = 0; c < array[0].length; c++) {
            if (array[r][c] === '#') {
                minR = Math.min(minR, r);
                minC = Math.min(minC, c);
                maxR = Math.max(maxR, r);
                maxC = Math.max(maxC, c);
            }
        }
    }
    
    return [minR, minC, maxR + 1, maxC + 1];
}
