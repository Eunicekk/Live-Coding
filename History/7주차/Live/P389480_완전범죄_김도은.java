import java.util.*;
import java.io.*;

class Solution {
    
    static class Product {
        int A;
        int B;
        
        public Product(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
    
    static int min;
    static Product[] products;
    
    public int solution(int[][] info, int n, int m) {
        products = new Product[info.length];
        
        int sumA = 0;
        int sumB = 0;
        
        for(int i = 0; i < info.length; i++) {
            products[i] = new Product(info[i][0], info[i][1]);
            sumA += info[i][0];
            sumB += info[i][1];
        }
        
        Arrays.sort(products, (a, b) -> a.A == b.A ? b.B - a.B : b.A - a.A);
        
        min = Integer.MAX_VALUE;
        int canA = 0;
        int canB = 0;
        
        comb(0, canA, canB, n, m);
        
        if(min == Integer.MAX_VALUE) return -1;
        
        return min;
    }
    
    public static void comb(int idx, int canA, int canB, int n, int m) {            
        if(canA >= n || canB >= m || min < canA) return; //못하는 조합경우
        
        if(idx >= products.length) {            
            min = Math.min(min, canA);
            return;
        }
        
        comb(idx + 1, canA, canB + products[idx].B, n, m);
        comb(idx + 1, canA + products[idx].A, canB, n, m);
        
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (1.83ms, 81.6MB)
테스트 2 〉	통과 (3.05ms, 87.2MB)
테스트 3 〉	통과 (2.08ms, 87.8MB)
테스트 4 〉	통과 (3.29ms, 111MB)
테스트 5 〉	통과 (29.90ms, 78.8MB)
테스트 6 〉	통과 (2026.74ms, 76.6MB)
테스트 7 〉	통과 (6554.74ms, 90.8MB)
테스트 8 〉	통과 (0.89ms, 102MB)
테스트 9 〉	통과 (2670.32ms, 79MB)
테스트 10 〉	통과 (5756.87ms, 87MB)
테스트 11 〉	통과 (0.97ms, 88.7MB)
테스트 12 〉	통과 (0.81ms, 81.3MB)
테스트 13 〉	통과 (1.13ms, 80.3MB)
테스트 14 〉	통과 (0.94ms, 82.8MB)
테스트 15 〉	통과 (0.87ms, 78.8MB)
테스트 16 〉	통과 (1.38ms, 89.6MB)
테스트 17 〉	통과 (1.10ms, 85.4MB)
테스트 18 〉	통과 (1.24ms, 86.5MB)
테스트 19 〉	통과 (1.27ms, 86.6MB)
테스트 20 〉	통과 (0.90ms, 84.4MB)
테스트 21 〉	통과 (1.71ms, 76.2MB)
테스트 22 〉	통과 (1.29ms, 91.2MB)
테스트 23 〉	통과 (0.83ms, 81.1MB)
테스트 24 〉	통과 (1.24ms, 84.4MB)
테스트 25 〉	통과 (1.31ms, 81.7MB)
테스트 26 〉	통과 (1315.10ms, 81.5MB)
테스트 27 〉	통과 (1.07ms, 70.8MB)
테스트 28 〉	통과 (6.52ms, 87.5MB)
테스트 29 〉	통과 (5.06ms, 86.2MB)
테스트 30 〉	통과 (1.48ms, 89.1MB)
테스트 31 〉	통과 (100.93ms, 97.6MB)
테스트 32 〉	통과 (1.21ms, 76.6MB)
테스트 33 〉	통과 (1.79ms, 90.9MB)
테스트 34 〉	통과 (98.15ms, 82.4MB)
테스트 35 〉	통과 (678.15ms, 99.2MB)
테스트 36 〉	통과 (1.49ms, 85.5MB)
테스트 37 〉	통과 (76.09ms, 83.8MB)
테스트 38 〉	통과 (0.78ms, 90.4MB)
테스트 39 〉	통과 (1.45ms, 85.5MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0

*/
