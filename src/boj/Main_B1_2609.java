package boj;

import java.util.Scanner;

public class Main_B1_2609 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int gcd = gcd(A, B);
		int lcm = A * B / gcd;
		
		System.out.println(gcd);
		System.out.println(lcm);
	}

	private static int gcd(int a, int b) {
		int mod = a % b;
		if (mod == 0) {
			return b;
		}
		
		return gcd(b, mod);
	}
}
