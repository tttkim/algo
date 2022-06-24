package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_1018 {
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N - 8 + 1; i++) {
			for (int j = 0; j < M - 8 + 1; j++) {
				int toChangeW = getMin(i, j, 'W');
				int toChangeB = getMin(i, j, 'B');
				if (toChangeW < min) {
					min = toChangeW;
				}
				if (toChangeB < min) {
					min = toChangeB;
				}
			}
		}
		System.out.println(min);
	}

	private static int getMin(int i, int j, char start) {
		int toChange = 0;
		for (int k = i; k < i + 8; k++) {
			for (int l = j; l < j + 8; l++) {
				if ((k - i) % 2 == 0) { // 홀수행
					if ((l - j) % 2 == 0) { // 홀수열
						if (map[k][l] != start) {
							toChange++;
						}
					} else {
						if (map[k][l] == start) {
							toChange++;
						}
					}
				} else if ((k - i) % 2 != 0) { // 짝수행
					if ((l - j) % 2 == 0) { // 홀수열
						if (map[k][l] == start) {
							toChange++;
						}
					} else {
						if (map[k][l] != start) {
							toChange++;
						}
					}
				}
			}
		}
		return toChange;
	}

}
