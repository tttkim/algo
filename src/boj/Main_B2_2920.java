package boj;

import java.util.Scanner;

public class Main_B2_2920 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int start = sc.nextInt();
		int before = sc.nextInt();
		String answer = null;
		if (start - before == 1) {
			answer = "descending";
		} else if (start - before == -1) {
			answer = "ascending";
		} else {
			System.out.println("mixed");
			return;
		}
		for (int i = 0; i < 6; i++) {
			int current = sc.nextInt();
			if (answer.equals("ascending") && current - before == 1) {
				answer = "ascending";
			} else if (answer.equals("descending") && current - before == -1) {
				answer = "descending";
			} else {
				System.out.println("mixed");
				return;
			}
			before = current;
		}
		System.out.println(answer);
	}
}
