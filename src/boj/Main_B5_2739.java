package boj;

import java.util.Scanner;

public class Main_B5_2739 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", N, i, N*i);
		}
	}
}
