import java.util.*;

class Solution {

    static int N;
    static int M;
    static int answer;
    static boolean bfs1_value;
    static boolean bfs2_value;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point {
        int r;
        int c;
        int v;

        public Point(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }

    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        String[][] board = new String[N][M];

        for (int r = 0; r < N; r++) {
            board[r] = maps[r].split("");
        }

        out: for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (board[r][c].equals("S")) {
                    bfs1(r, c, board);
                    break out;
                }
            }
        }

        if (!bfs1_value) return -1;

        out: for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (board[r][c].equals("L")) {
                    bfs2(r, c, board);
                    break out;
                }
            }
        }

        if (bfs1_value && bfs2_value) {
            return answer;
        } else {
            return -1;
        }
    }

    static void bfs1(int r, int c, String[][] board) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        queue.offer(new Point(r, c, 0));
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = point.r + dr[d];
                int nc = point.c + dc[d];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visit[nr][nc]) {
                    visit[nr][nc] = true;

                    if (board[nr][nc].equals("O") || board[nr][nc].equals("S") || board[nr][nc].equals("E")) {
                        queue.offer(new Point(nr, nc, point.v + 1));
                    } else if (board[nr][nc].equals("L")) {
                        bfs1_value = true;
                        answer += point.v + 1;
                        return;
                    }
                }
            }
        }
    }

    static void bfs2(int r, int c, String[][] board) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        queue.offer(new Point(r, c, 0));
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = point.r + dr[d];
                int nc = point.c + dc[d];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visit[nr][nc]) {
                    visit[nr][nc] = true;

                    if (board[nr][nc].equals("O") || board[nr][nc].equals("L") || board[nr][nc].equals("S")) {
                        queue.offer(new Point(nr, nc, point.v + 1));
                    } else if (board[nr][nc].equals("E")) {
                        bfs2_value = true;
                        answer += point.v + 1;
                        return;
                    }
                }
            }
        }
    }
}
