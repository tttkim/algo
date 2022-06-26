package boj;

import java.util.Scanner;

public class Main_S2_1654 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[K];
		long min = 1;
		long max = 0;
		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		max += 1;
		while (min < max) {
			long mid = (max + min) / 2;
			long cnt = 0;
			for (int i = 0; i < K; i++) {
				cnt += arr[i] / mid;
			}
			
			if (cnt < N)
				max = mid;
			else
				min = mid+1;
		}
		
		System.out.println(min-1);

	}
}
