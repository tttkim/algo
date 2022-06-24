package boj;

import java.util.Scanner;

public class Main_B1_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			if (temp > max) {
				max = temp;
			}
			sum += temp;
		}
		
		System.out.println((double)sum * 100 / max / n);
		
	}
}
