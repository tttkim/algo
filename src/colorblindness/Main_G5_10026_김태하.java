package colorblindness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_10026_김태하 {
	static int N, cnt, cnt2;
	static char[][] map, map2;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		map2 = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			map2[i] = Arrays.copyOf(map[i], N);
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 'A') {
					bfs(i, j, map[i][j], map);
					cnt++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map2[i][j] == 'G') {
					map2[i][j] = 'R';
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map2[i]));
//		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map2[i][j] != 'A') {
					bfs(i, j, map2[i][j], map2);
					cnt2++;
				}
			}
		}
		
		System.out.println(cnt + " " + cnt2);
		
	}

	private static void bfs(int r, int c, char color, char[][] map) {
		Queue<int[]> queue = new LinkedList<>();
		
		int[] start = new int[] {r, c, color};
		map[r][c] = 'A';
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == color) {
					queue.offer(new int[] {nr, nc});
					map[nr][nc] = 'A';
				}
			}
		}
	}
}
