package mazeescaperobot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_문제은행_1661_bfs_dfs_김태하 {
	// dfs로 풀 경우 다음 지점에 도착할 때마다 최소 거리를 갱신한 뒤 다른 경로를 통해 갔을 때 해당 경로보다 같거나 길어지면 끝까지 보지 않고 중간에서 return하는 방식
	
	static int X, Y, minCnt, startX, startY, destX, destY;
	static char[][] map;
	static boolean[][] hasVisited;
	static int[][] minMap;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new char[Y][X];
		minMap = new int[Y][X];
		for (int i = 0; i < Y; i++) {
			Arrays.fill(minMap[i], Integer.MAX_VALUE);
		}
		hasVisited = new boolean[Y][X];
//		minCnt = 0;
		minCnt = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken()) - 1;
		startY = Integer.parseInt(st.nextToken()) - 1;
		destX = Integer.parseInt(st.nextToken()) - 1;
		destY = Integer.parseInt(st.nextToken()) - 1;
		for (int i = 0; i < Y; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
//		bfs(new Place(startX, startY, 0));
		dfs(new Place(startX, startY, 0));
		System.out.println(minCnt);
		
	}
	
	private static void dfs(Place current) {
//		hasVisited[current.Y][current.X] = true;
		if (current.level >= minCnt) {
			return;
		}
		

		minMap[current.Y][current.X] = current.level;

		
		if (current.X == destX && current.Y == destY) {
			minCnt = Math.min(current.level, minCnt);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = current.Y + dr[i];
			int nc = current.X + dc[i];
			if (nr > -1 && nr < Y && nc > -1 && nc < X && map[nr][nc] != '1' && hasVisited[nr][nc] == false && minMap[nr][nc] > current.level + 1) {
				hasVisited[nr][nc] = true;
				dfs(new Place(nc, nr, current.level + 1));
				hasVisited[nr][nc] = false;
			}
		}
	}

	static class Place {
		int X;
		int Y;
		int level;
		
		public Place(int x, int y, int level) {
			super();
			X = x;
			Y = y;
			this.level = level;
		}
		public Place() {
			this(0, 0, 0);
		}
	}
	
	private static void bfs(Place current) {
		Queue<Place> queue = new LinkedList<Place>();
		hasVisited[current.Y][current.X] = true;
		queue.offer(current);
		
		while (!queue.isEmpty()) {
			
			current = queue.poll();
			if (current.X == destX && current.Y == destY) {
				minCnt = current.level;
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = current.Y + dr[i];
				int nc = current.X + dc[i];
				if (nr > -1 && nr < Y && nc > -1 && nc < X && map[nr][nc] != '1' && hasVisited[nr][nc] == false) {
					hasVisited[nr][nc] = true;
					queue.offer(new Place(nc, nr, current.level + 1));
				}
			}
		}
	}
}
