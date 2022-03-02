package blackjack;

import java.util.Scanner;

public class Main_B2_2798_김태하 {
	static int N, M, maxVal;
	static int[] cards;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		cards = new int[N];
		
		for (int i = 0; i < N; i++) {
			cards[i] = scanner.nextInt();
		}
		
		combination(0, 0, 0);
		
		System.out.println(maxVal);
		
		scanner.close();
	}

	private static void combination(int cnt, int start, int sum) {
		if (cnt >= 3) {
			if (sum <= M && sum > maxVal) {
				maxVal = sum;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			combination(cnt + 1, i + 1, sum + cards[i]);
		}
		
	}
	
	
}
