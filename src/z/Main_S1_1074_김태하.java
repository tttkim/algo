package z;

import java.util.Scanner;

public class Main_S1_1074_김태하 {
	static int N, R, C;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		R = scanner.nextInt();
		C = scanner.nextInt();
		
		find(N, 0, R, C);
		
		scanner.close();
	}

	private static void find(int n, int start, int r, int c) {
		if (n == 0) {
			System.out.println(start);
			return;
		}
		
		int mid = (int)Math.pow(2, n-1);
		
		if (r < mid) {
			if (c < mid) {
				find(n - 1, start, r, c);
				return;
			} else if (c >= mid) {
				find(n - 1, start + mid * mid, r, c - mid);
				return;
			}
		} else {
			if (c < mid) {
				find(n - 1, start + 2 * mid * mid, r - mid, c);
				return;
			} else if (c >= mid) {
				find(n - 1, start + 3 * mid * mid, r - mid, c - mid);
				return;
			}
		}
	}
}
