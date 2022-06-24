package boj;

import java.util.Scanner;

public class Main_B2_3052 {
	static int[] arr = new int[42];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			int temp = sc.nextInt();
			arr[temp%42]++;
		}
		
		int cnt = 0;
		for (int i = 0; i < 42; i++) {
			if (arr[i] != 0)
				cnt++;
		}
		System.out.println(cnt);
	}
}
