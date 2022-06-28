package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S2_1012 {
	static boolean[][] map;
	static int M, N, K, cnt;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cnt = 0;
			map = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				map[r][c] = true;
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c]) {
						dfs(r, c);
						cnt++;
					}
				}
			}
			bw.write(Integer.toString(cnt));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	private static void dfs(int r, int c) {
		map[r][c] = false;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc])
				dfs(nr, nc);
		}
	}
}
