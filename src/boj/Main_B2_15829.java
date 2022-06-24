package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B2_15829 {
	static long[] pows = new long[51];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(pows, -1);
		
		int N = sc.nextInt();
		sc.nextLine();
		char[] charr = sc.nextLine().toCharArray();
		long sum = 0;
		long pow = 1;
		for (int i = 0; i < N; i++) {
			sum += (charr[i]-'a'+1) * pow % 1234567891;
			pow = pow * 31 % 1234567891;
		}
		sum = sum % 1234567891;
		System.out.println(sum);
	}
}
