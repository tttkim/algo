package boj;

import java.util.Scanner;

public class Main_B2_2292 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int step = 1;
		int ring = 1;
		
		if (N == 1) {
			System.out.println(1);
		} else {
			while (ring < N) {
				ring += step * 6;
				step++;
			}
			System.out.println(step);
		}
	}
}
