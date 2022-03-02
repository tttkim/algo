package tomato;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_G5_7576_김태하 {
	static int M, N, cnt;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		M = scanner.nextInt();
		N = scanner.nextInt();
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		
		bfs(0, 0, 0);
		System.out.println(cnt);
		scanner.close();
	}
	
	private static void bfs(int r, int c, int level) {
		Queue<int[]> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					int[] start = {i, j, level};
					queue.offer(start);
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
					map[nr][nc] = 1;
					cnt = current[2] + 1;
					int[] next = {nr, nc, current[2] + 1};
					queue.offer(next);
				}
			}
		}
		
		if (!isFinished()) {
			cnt = -1;
		}
	}
	
	public static boolean isFinished() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
}
