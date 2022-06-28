package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S3_2579 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[][] dp = new int[N+1][2];
		dp[0][0] = arr[0];
		dp[1][0] = arr[0] + arr[1];
		dp[1][1] = arr[1];
		for (int i = 2; i < N; i++) {
			dp[i][0] = arr[i] + dp[i-1][1]; 								// i에 한 칸 이동해서 도착하려면 i-1까지 2칸 이동해서 도착해야 한다.
			dp[i][1] = arr[i] + Math.max(dp[i-2][0], dp[i-2][1]);			// i에 두 칸 이동해서 도착하려면 i-2에서 도착해야 한다.
		}
		
		System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
	}

}
