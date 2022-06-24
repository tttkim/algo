package boj;

import java.util.Scanner;

public class Main_B2_2675 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			StringBuilder sb = new StringBuilder();
			int N = sc.nextInt();
			char[] arr = sc.next().toCharArray();
			
			for (char c : arr) {
				for (int j = 0; j < N; j++) {
					sb.append(c);
				}
			}
			System.out.println(sb.toString());
		}
	}
}
