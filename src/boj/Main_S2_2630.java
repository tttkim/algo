package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_2630 {
	static int[][] map;
	static int[] colorPapers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		colorPapers = new int[2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check(0, 0, N);
		System.out.println(colorPapers[0]);
		System.out.println(colorPapers[1]);
	}

	private static void divide(int x, int y, int n) {
		check(x, y, n/2);
		check(x, y+n/2, n/2);
		check(x+n/2, y, n/2);
		check(x+n/2, y+n/2, n/2);
	}

	private static void check(int i, int j, int k) {
		int color = map[i][j];
		for (int r = i; r < i+k; r++) {
			for (int c = j; c < j+k; c++) {
				if (map[r][c] != color) {
					divide(i, j, k);
					return;
				}
			}
		}
		colorPapers[color] += 1;
	}

}
