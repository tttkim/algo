package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_18111 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] < min)
					min = map[i][j];
				if (map[i][j] > max)
					max = map[i][j];
			}
		}
		
		int minTime = Integer.MAX_VALUE;
		int maxHeight = 0;
		int height = min;
		while (height <= max) {
			int curTime = 0;
			int put = 0;
			int dig = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > height)
						dig += map[i][j] - height;
					if (map[i][j] < height)
						put += height - map[i][j];
				}
			}
			curTime = put + (dig * 2);
			if ((dig + B) >= put && curTime <= minTime) {
				minTime = curTime;
				maxHeight = height;
			}
			height++;
		}
		System.out.println(minTime + " " + maxHeight);
	}
}
