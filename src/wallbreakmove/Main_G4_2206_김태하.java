package wallbreakmove;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_G4_2206_김태하 {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		M = scanner.nextInt();
		scanner.nextLine();
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = scanner.nextLine().toCharArray();
		}
		
		bfs(0, 0, 1, 1);
		
	}

	private static void bfs(int r, int c, int level, int breakable) {
		Queue<int[]> queue = new LinkedList<>();
		
		if (map[r][c] == '1') {
			map[r][c] = '0';
			breakable = 0;
		}
		
		if (map[N-1][M-1] == '1' && breakable == 1) {
			map[N-1][M-1] = '0';
			breakable = 0;
		}
		
		queue.offer(new int[] {r, c, level, breakable});
		visited[r][c] = true;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			
//			System.out.printf("%d : [%d %d] %d\n", current[2], current[0], current[1], current[3]);
			
			if (current[0] == N - 1 && current[1] == M - 1) {
				System.out.println(current[2]);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
					if (map[nr][nc] == '0') {
						queue.offer(new int[] {nr, nc, current[2] + 1, current[3]});
						visited[nr][nc] = true;
					} else {
						if (current[3] == 1) {
							queue.offer(new int[] {nr, nc, current[2] + 1, 0});
							map[nr][nc] = '0';
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
		System.out.println("-1");
	}
}
