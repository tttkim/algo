package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_B1_10989 {
	static int[] arr = new int[10001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		for (int i = 1; i <= 10000; i++) {
			if (arr[i] != 0) {
				for (int j = 0; j < arr[i]; j++) {
					bw.write(String.valueOf(i));
					bw.newLine();
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
