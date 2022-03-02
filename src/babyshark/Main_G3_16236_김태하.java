package babyshark;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_16236_김태하 {
	static int N;		// 맵 크기
	static int M;		// 물고기의 수
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean isFinished;
	static boolean[][] visited;
	static int curr, curc, seconds, exp, size;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		curr = 0;
		curc = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 9) {
					curr = i;
					curc = j;
					map[i][j] = 0;
				}
			}
		}
		
		seconds = 0;
		size = 2;
		
		while (!isFinished) {
			resetVisited();
			bfs(curr, curc, 0);									// 먹잇감 찾기
		}
		
		System.out.println(seconds);
	}

	private static void bfs(int r, int c, int level) {
		
//		System.out.println("starts with " + r + " " + c);
		
		Queue<int[]> queue = new LinkedList<int[]>();
		ArrayList<int[]> arr = new ArrayList<int[]>();
		
		queue.offer(new int[] {r, c, level});
		visited[r][c] = true;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			
			if (map[current[0]][current[1]] > 0 && map[current[0]][current[1]] < size) {
				arr.add(current);
//				System.out.println("Added " + Arrays.toString(current));
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] <= size) {
					queue.offer(new int[] {nr, nc, current[2] + 1});
					visited[nr][nc] = true;
				}
			}
		}
//		for (int[] a : arr) {
//			System.out.print(Arrays.toString(a) + " ");
//		}
//		System.out.println();
		
		arr.sort((a, b)-> a[2] != b[2] ? a[2] - b[2] : (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
//		
//		for (int[] a : arr) {
//			System.out.print(Arrays.toString(a) + " ");
//		}
		
		if (!arr.isEmpty()) {
			int[] target = arr.get(0);
			int rr = target[0];
			int cc = target[1];
			int cnt = target[2];
			
			map[rr][cc] = 0;
			curr = rr;
			curc = cc;
			seconds += cnt;
			if (++exp >= size) {
				size++;
				exp = 0;
			}
//			System.out.println("Ate " + rr + " " + cc + "!! size : " + size + " exp : " + exp + " curr = " + curr + " curc = " + curc );
			
		} else {
			isFinished = true;
		}
	}
	
	private static void resetVisited() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
	}
}
