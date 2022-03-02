package pat;

import java.util.Scanner;

public class Main {
	static int[] numbers;
	static int N, K;

	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		numbers = new int[N];
		
		pat(0, 0);
	}
	
	public static void pat(int total, int numOfOne) {
		if (total == N) {
			if (numOfOne == K) {
				for(int i = 0; i < N; i++) {
					System.out.printf("%d", numbers[i]);
				}
				System.out.println();
			}
			return;
		}
		numbers[total] = 1;
		pat(total+1, numOfOne+1);
		numbers[total] = 0;
		pat(total+1, numOfOne);
	}
}
