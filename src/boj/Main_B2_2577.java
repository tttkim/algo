package boj;

import java.util.Scanner;

public class Main_B2_2577 {
	static int[] arr = new int[10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = 1;
		for (int i = 0; i < 3; i++) {
			num *= sc.nextInt();
		}
		
		while (num != 0) {
			arr[num % 10]++;
			num /= 10;
		}
		
		for (int n : arr)
			System.out.println(n);
	}
}
