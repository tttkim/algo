package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B2_15830_memoization {
	static long[] pows = new long[51];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(pows, -1);
		
		int N = sc.nextInt();
		sc.nextLine();
		char[] charr = sc.nextLine().toCharArray();
		long sum = 0;
		for (int i = 0; i < N; i++) {
			long a = charr[i]-'a'+1 % 1234567891;
			long r = getPow(i);
			long res = (a * r) % 1234567891;
			sum += res;
		}
		sum = sum % 1234567891;
		System.out.println(sum);
	}

	private static long getPow(int i) {
		if (pows[i] != -1) {
			return pows[i];
		}
		
		if (i <= 1) {
			pows[i] = (long)Math.pow(31, i) % 1234567891;
			return pows[i];
		}
		
		if (i % 2 == 0) {
			pows[i] = ((getPow(i/2) % 1234567891) * (getPow(i/2) % 1234567891)) % 1234567891;
		} else {
			pows[i] = ((getPow(i-1) % 1234567891) * (getPow(1) % 1234567891)) % 1234567891;
		}
		return pows[i];
	}
}

