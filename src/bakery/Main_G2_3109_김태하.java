package bakery;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G2_3109_김태하 {
	static int R, C, cnt;
	static char[][] map;
	static int[] dr = {-1, 0, 1}; // 오른쪽 대각선 위, 오른쪽, 오른쪽 대각선 아래
	static boolean flag;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			flag = false;
			steal(i, 0);
		}
		
		System.out.println(cnt);
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}

	private static void steal(int r, int c) {
		// 처음과 마지막 열은 항상 비어있다. -> 처음이 비어있지 않은 경우를 고려하지 않는다.
		
		map[r][c] = '-';
		
		if (c == C - 1) {
			flag = true;
			cnt++;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if (!flag) {
				int nr = r + dr[i];
				if (nr < 0 || nr == R || map[nr][c + 1] == 'x' || map[nr][c + 1] == '-') {
					continue;
				}
				steal(nr, c + 1);
			}
		}
		
	}
}
