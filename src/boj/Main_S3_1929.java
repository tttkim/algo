package boj;

import java.util.Scanner;

public class Main_S3_1929 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		for (int i = M; i <= N; i++) {
			if (i == 1)
				continue;
			else if (i == 2)
				System.out.println(i);
			else if (isPrime(i))
				System.out.println(i);
		}
		
	}

	private static boolean isPrime(int i) {
		int sqrt = (int)Math.ceil(Math.sqrt(i));
		for (int j = 2; j <= sqrt; j++) {
			if (i % j == 0)
				return false;
		}
		return true;
	}
	
	

}
