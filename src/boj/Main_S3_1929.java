package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_S3_1929 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());;
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());;
			int[][] arr = new int[N+1][2];
			
			for (int i = 0; i <= N; i++) {
				if (i == 0) {
					arr[i][0] = 1;
					arr[i][1] = 0;
				} else if (i == 1) {
					arr[i][0] = 0;
					arr[i][1] = 1;
				} else {
					arr[i][0] = arr[i-1][0] + arr[i-2][0];
					arr[i][1] = arr[i-1][1] + arr[i-2][1];
				}
			}
			bw.write(arr[N][0] + " " + arr[N][1]);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	

}
