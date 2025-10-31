function solution(s) {
    let array = s.split("");
    let length = array.length;
    let result = 0;
    
    const palindrome = (left, right) => {
        while (left >= 0 && right < length && array[left] === array[right]) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
    
    for (let i = 0; i < length; i++) {
        let odd = palindrome(i, i);
        let even = palindrome(i, i + 1);
        let max = Math.max(odd, even);
        result = Math.max(result, max);
    }
    
    return result;
}
