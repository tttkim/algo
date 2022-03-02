package spotmart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_9229_김태하 {
	static int TC, N, M, selectedTotal;
	static int[] snacks;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			TC = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= TC; tc++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				snacks = new int[N];
				String[] temp = br.readLine().split(" ");
				for (int i = 0; i < N; i++) {
					snacks[i] = Integer.parseInt(temp[i]);
				}
				selectedTotal = -1;
				for (int i = 0; i < N - 1; i++) {
					for (int j = i + 1; j < N; j++) {
						int sum = snacks[i] + snacks[j];
						if (sum > M) {
							continue;
						}
						if (sum > selectedTotal) {
							selectedTotal = sum;
						}
					}
				}
				bw.write(String.format("#%d ", tc));
				bw.write(String.format("%d ", selectedTotal));
				bw.newLine();
			}
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
