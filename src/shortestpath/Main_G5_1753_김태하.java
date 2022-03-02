package shortestpath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1753_김태하 {
	static int V, E, K;
//	static int[][] map;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine()) - 1;
		
//		map = new int[V][V];
		int start = 0;
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			
			map[u][v] = w;
		}
		
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[start] = 0;
		
		for (int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0;
			
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			
			for (int j = 0; j < V; j++) {
				if (!visited[j] && map[current][j] != 0 && distance[j] > distance[current] + map[current][j]) {
					distance[j] = distance[current] + map[current][j];
				}
			}
		}
		
		for (int i = 0; i < V; i++) {
			System.out.println(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]); 
		}
		
	}
}
