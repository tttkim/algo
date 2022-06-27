package boj;

import java.util.Scanner;

public class Main_S5_1676 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[2];
		
		for (int i = 1; i <= N; i++) {
			int num = i;
			while (num % 2 == 0) {
				arr[0]++;
				num /= 2;
			}
			while (num % 5 == 0) {
				arr[1]++;
				num /= 5;
			}
		}
		
		System.out.println(Math.min(arr[0], arr[1]));

	}
}
