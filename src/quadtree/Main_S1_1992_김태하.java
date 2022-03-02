package quadtree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S1_1992_김태하 {
	// 배열을 4등분한다.
	// 		모두 같으면 해당 숫자를 압축 결과에 추가한다.
	// 		모두 같지 않으면 "(" + 숫자들 + ")"을 압축 결과에 추가한다.
	
	static int N;
	static char[][] video;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		video = new char[N][];
		for (int i = 0; i < N; i++) {
			video[i] = br.readLine().toCharArray();
		}
		
		zip(0, 0, N);
		System.out.println(sb.toString());
	}

	private static void zip(int startr, int startc, int n) {
		if (isIdentical(startr, startc, n)) {
			sb.append(video[startr][startc]);
		} else {
			sb.append("(");
			zip(startr, startc, n/2);
			zip(startr, startc + n/2, n/2);
			zip(startr + n/2, startc, n/2);
			zip(startr + n/2, startc + n/2, n/2);
			sb.append(")");
		}
	}

	private static boolean isIdentical(int startr, int startc, int n) {
		int sample = video[startr][startc];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (sample != video[startr + i][startc + j]) {
					return false;
				}
			}
		}
		return true;
	}
}
