package hanaro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D4_1251_김태하 {
	// Kruskal 알고리즘을 이용해서 환경부담금이 가장 적은 스패닝 트리 만들고 총 환경부담금을 출력
	
	static int T, N;
	static double E;
	static int[] parents;
	static Long[][] islands;
	static ArrayList<Edge> edges;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			edges = new ArrayList<>();
			
			islands = new Long[N][2];
			
			// 섬 정보 입력 받기
			// x값 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				islands[i][0] = Long.parseLong(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			// y값 입력
			for (int i = 0; i < N; i++) {
				islands[i][1] = Long.parseLong(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			// 한 섬에서 다른 섬으로의 이동 비용을 모두 구해 리스트로 만든다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Long[] from = islands[i];
					Long[] to = islands[j];
					long weight = (long)(Math.pow(from[0] - to[0], 2) + Math.pow(from[1] - to[1], 2));
					
					edges.add(new Edge(i, j, weight));
				}
			}
			
			// 리스트를 정렬한다.
			edges.sort((a, b) -> a.compareTo(b));
			makeSet();
			
			long result = 0;
			int cnt = 0;
			
			for (Edge edge : edges) {
				if (union(edge.from, edge.to)) {
//					System.out.println(edge.from + " -> " + edge.to + " " + edge.weight);
					result += edge.weight;
					if (++cnt == N-1) {
						break;
					}
				}
			}
			double newresult = result * E;
			System.out.printf("#%d %.0f\n", tc, newresult);
		}
		
	}
	
	static class Edge implements Comparable<Edge> {
		int from, to;
		Long weight;
		
		public Edge(int from, int to, Long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}

	public static void makeSet() {
		parents = new int[N];
		
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
	
}
