package boj;

import java.util.Scanner;

public class Main_S4_11047 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}
		
		int cnt = 0;
		for (int i = N-1; i >= 0; i--) {
			while (coins[i] <= K) {
				K -= coins[i];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	

}
