package knightmove;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_S2_7562_김태하 {
	// bfs, delta
	
	static int T, I, startr, startc, destr, destc, answer;
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};		// 왼쪽 위부터 시계방향
	static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			I = startr = startc = destr = destc = answer = 0;
			I = scanner.nextInt();
			
			visited = new boolean[I][I];
			
			startr = scanner.nextInt();
			startc = scanner.nextInt();
			destr = scanner.nextInt();
			destc = scanner.nextInt();
			
			bfs(startr, startc, 0);
			
			System.out.println(answer);
		}
		
		scanner.close();
	}

	private static void bfs(int startr, int startc, int level) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {startr, startc, level});
		visited[startr][startc] = true;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			
			if (current[0] == destr && current[1] == destc) {
				answer = current[2];
				return;
			}
			
			for (int next = 0; next < 8; next++) {
				int nr = current[0] + dr[next];
				int nc = current[1] + dc[next];
				
				if (nr >= 0 && nr < I && nc >= 0 && nc < I && !visited[nr][nc]) {
					queue.offer(new int[] {nr, nc, current[2] + 1});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
