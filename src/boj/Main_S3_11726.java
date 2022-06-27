package boj;

import java.util.Scanner;

public class Main_S3_11726 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				arr[i] = 1;
			} else if (i == 2) {
				arr[i] = 2;
			} else {
				arr[i] = ((arr[i-1] % 10007) + (arr[i-2] % 10007)) % 10007;
			}
		}
		System.out.println(arr[N]);
	}
	
	

}
