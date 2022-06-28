package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S3_9095 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());;
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());;
			int[] arr = new int[N+4];
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;
			for (int i = 4; i <= N; i++) {
				arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
			}
			bw.write(Integer.toString(arr[N]));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	

}
