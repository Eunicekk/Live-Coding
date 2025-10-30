function solution(queue1, queue2) {
    let max = (queue1.length + queue2.length) * 2;
    let count = 0;
    let sum1 = queue1.reduce((acc, cur) => acc + cur, 0);
    let sum2 = queue2.reduce((acc, cur) => acc + cur, 0);
    let target = (sum1 + sum2) / 2;
    
    let queue = [...queue1, ...queue2];
    let left = 0;
    let right = queue1.length;
    
    while (count <= max) {
        if (sum1 === target) {
            return count;
        }
        
        if (sum1 > target) {
            sum1 -= queue[left];
            left++;
        } else {
            sum1 += queue[right % queue.length];
            right++;
        }

        count++;
    }
    
    return -1;
}
