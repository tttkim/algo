package dfsnbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1260_김태하 {
	
	static int N, M, V;
	static int[][] map;
	static boolean[] hasVisited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		hasVisited = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			
			map[start][to] = 1;
			map[to][start] = 1;
		}

		dfs(V - 1);
		System.out.println();
		hasVisited = new boolean[N];
		bfs(V - 1);
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}

	private static void dfs(int current) {
		hasVisited[current] = true;
		
		System.out.printf("%d ", current + 1);
		
		for (int ad = 0; ad < N; ad++) {
			if (map[current][ad] != 0 && !hasVisited[ad]) {
				dfs(ad);
			}
		}
	}

	private static void bfs(int current) {
		Queue<Integer> queue = new LinkedList<Integer>();
		hasVisited[current] = true;
		
		queue.offer(current);
		
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.printf("%d ", current + 1);
			
			for (int ad = 0; ad < N; ad++) {
				if (map[current][ad] != 0 && !hasVisited[ad]) {
					hasVisited[ad] = true;
					queue.offer(ad);
				}
			}
		}
	}
}