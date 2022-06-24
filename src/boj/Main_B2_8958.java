package boj;

import java.util.Scanner;

public class Main_B2_8958 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < T; i++) {
			char[] results = sc.nextLine().toCharArray();
			int streak = 0;
			int score = 0;
			for (char c : results) {
				if (c == 'O') {
					streak += 1;
					score += streak;
				} else {
					streak = 0;
				}
			}
			System.out.println(score);
		}
	}
}
