package isthegreenonezelda;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_4485_김태하 {
	
	static int N;
	static int[][] adjMatrix;
	static boolean isFinished;
	
	public static class Edge implements Comparable<Edge>{
		int r, c, minDistance;

		public Edge(int r, int c, int minDistance) {
			super();
			this.r = r;
			this.c = c;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Edge o) {
			return this.minDistance - o.minDistance;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (!isFinished) {
			N = Integer.parseInt(br.readLine());
			
			List<Edge>[] adjList = new ArrayList[N];
					
			if (N == 0) {
				isFinished = true;
				continue;
			}
			
			for (int i = 0; i < N; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			StringTokenizer st = null;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					adjList[i].add(new Edge(i, j, Integer.parseInt(st.nextToken())));
				}
			}
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			Edge[][] distance = new Edge[N][N];
			boolean[][] visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == 0 && j == 0) {
						distance[i][j] = new Edge(i, j, 0);	// 나중에 adjList[0][0]의 값을 더해줘야 한다.
					} else {
						distance[i][j] = new Edge(i, j, Integer.MAX_VALUE);
					}
					pq.add(distance[i][j]);
				}
			}
			
			while (!pq.isEmpty()) {
				Edge Edge = pq.poll();
				
				for ()
			}
		}
		
		
	}
}
