package nemo;

import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		 
		for (int i = 0; i < N; i++) {
			if (i == 0 || i == N-1) {
				for (int j = 0; j < N; j++) {
					System.out.print('*');
				}
			} else {
				for (int j = 0; j < N; j++) {
					if (j == 0 || j == N-1) {
						System.out.print('*');
					} else {
						System.out.print(' ');
					}
				}
			}
			System.out.println();
		} 
	}
	
	
}
