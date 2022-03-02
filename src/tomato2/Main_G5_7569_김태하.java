package tomato2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_7569_김태하 {
	static int M, N, H, cnt;
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	static int[][][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		bfs(0, 0, 0, 0);
		System.out.println(cnt);
		
	}

	private static void bfs(int starth, int startr, int startc, int level) {
		Queue<int[]> queue = new LinkedList<>();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 1) {
						int[] temp = {i, j, k, 0};
						queue.offer(temp);
					}
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			cnt = current[3];
			
			for (int i = 0; i < 4; i++) {
				int nr = current[1] + dr[i];
				int nc = current[2] + dc[i];
				if (isAvailable(current[0], nr, nc)) {
					queue.offer(new int[] {current[0], nr, nc, current[3] + 1});
					map[current[0]][nr][nc] = 1;
				}
			}
			
			if (isAvailable(current[0] - 1, current[1], current[2])) {
				queue.offer(new int[] {current[0] - 1, current[1], current[2], current[3] + 1});
				map[current[0] - 1][current[1]][current[2]] = 1;
			}
			
			if (isAvailable(current[0] + 1, current[1], current[2])) {
				queue.offer(new int[] {current[0] + 1, current[1], current[2], current[3] + 1});
				map[current[0] + 1][current[1]][current[2]] = 1;
			}
			
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 0) {
						cnt = -1;
					}
				}
			}
		}
	}
	
	private static boolean isAvailable(int h, int r, int c) {
		if (h >= 0 && h < H && r >= 0 && r < N && c >= 0 && c < M && map[h][r][c] == 0) {
			return true;
		}
		return false;
	}
	
}
