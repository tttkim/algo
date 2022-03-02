package hamburgerdiet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_D3_5215_김태하 {
	static int T, N, L, highTaste;
	static int[] tasteScores, cals;
	static boolean[] selected;
	
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			T = Integer.parseInt(br.readLine());
			
			for (int tc = 1; tc <= T; tc++) {
				String[] temp = br.readLine().split(" ");
				N = Integer.parseInt(temp[0]);
				L = Integer.parseInt(temp[1]);
				tasteScores = new int[N];
				cals = new int[N];
				selected = new boolean[N];
				highTaste = 0;
				
				for (int i = 0; i < N; i++) {
					temp = br.readLine().split(" ");
					tasteScores[i] = Integer.parseInt(temp[0]);
					cals[i] = Integer.parseInt(temp[1]);
				}
				
				
				generateSubset(0, 0);
				
				bw.write(String.format("#%d %d", tc, highTaste));
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void generateSubset(int cnt, int cal) {
		if (cal > L) {
			return;
		}
		if (cnt == N) {
			int totalTaste = 0;
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					totalTaste += tasteScores[i];
				}
			}
			if (totalTaste > highTaste) {
				highTaste = totalTaste;
			}
			return;
		}
		selected[cnt] = true;
		generateSubset(cnt + 1, cal + cals[cnt]);
		
		selected[cnt] = false;
		generateSubset(cnt + 1, cal);
		
	}
}
