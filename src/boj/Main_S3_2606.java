package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S3_2606 {
	static boolean[] computers;
	static int cnt;
	static int N, M;
	static ArrayList<ArrayList<Integer>> adlist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adlist = new ArrayList<>();
		computers = new boolean[N];
		cnt = 0;
		
		for (int i = 0; i < N; i++) {
			adlist.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			
			adlist.get(from).add(to);
			adlist.get(to).add(from);
		}
		
		dfs(0);
		
		System.out.println(cnt - 1);
	}
	private static void dfs(int cur) {
		if (computers[cur])
			return;
		computers[cur] = true;
		cnt++;
		
		for (int next : adlist.get(cur)) {
			dfs(next);
		}
	}

}
