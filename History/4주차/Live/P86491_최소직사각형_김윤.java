class Solution {
    public int solution(int[][] sizes) {
        int max_width = Integer.MIN_VALUE;
        int max_height = Integer.MIN_VALUE;
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][1] > sizes[i][0]) {
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
            
            max_height = Math.max(max_height, sizes[i][0]);
            max_width = Math.max(max_width, sizes[i][1]);
        }

        return max_height * max_width;
    }
}
