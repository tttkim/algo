package rotatearray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S2_16926_김태하 {
	static int N, M, R;
	static int[] dr = {0, 1, 0, -1};	// 우하좌상
	static int[] dc = {1, 0, -1, 0};
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int boundaryNum = Math.min(N, M) / 2;
		for (int boundary = 0; boundary < boundaryNum; boundary++) {
			for (int i = 0; i < R; i++) {
				int r = boundary;
				int c = boundary;
				int temp = map[boundary][boundary];
				
				int sideChange = 0;
				
				while (sideChange < 4) {	// 네 변에 대해 모두 적용
					int nr = r + dr[sideChange];
					int nc = c + dc[sideChange];
					
					if (nr >= boundary && nr < N - boundary && nc >= boundary && nc < M - boundary ) {
						map[r][c] = map[nr][nc];
						r = nr;
						c = nc;
					} else {
						
						sideChange++;
					}
				}
				map[boundary + 1][boundary] = temp;
			}
		}
			
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(map[i][j] + " ");
			}
			bw.newLine();;
		}
		bw.flush();
		bw.close();
	}
}
