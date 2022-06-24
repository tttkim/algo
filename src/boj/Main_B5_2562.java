package boj;

import java.util.Scanner;

public class Main_B5_2562 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max = 0;
		int maxi = 0;
		for (int i = 1; i <= 9; i++) {
			int temp = sc.nextInt();
			if (temp > max) {
				max = temp;
				maxi = i;
			}
		}
		System.out.println(max);
		System.out.println(maxi);
	}
}
