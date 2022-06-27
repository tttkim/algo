package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S4_11399 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int waitTime = 0;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			waitTime += arr[i];
			answer += waitTime;
		}
		
		System.out.println(answer);
	}
	
	

}
