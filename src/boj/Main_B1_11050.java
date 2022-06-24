package boj;

import java.util.Scanner;

public class Main_B1_11050 {
	static int ans, N, M;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ans = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		comb(0, 0);
		System.out.println(ans);
		
	}
	private static void comb(int cnt, int start) {
		if (cnt == M) {
			ans++;
			return;
		}
		
		for (int i = start; i < N; i++) {
			comb(cnt+1, i+1);
		}
	}
}
