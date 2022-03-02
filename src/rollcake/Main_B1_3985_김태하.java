package rollcake;

import java.util.Scanner;

public class Main_B1_3985_김태하 {
	
	static int L, N;
	static int[] cake, reality;
	static int[][] audience;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		L = scanner.nextInt();
		N = scanner.nextInt();
		
		cake = new int[L];
		reality = new int[N];
		audience = new int[N][2];
		
		int expected = 0;
		int exp = 0;
		for (int i = 0; i < N; i++) {
			audience[i][0] = scanner.nextInt() - 1;
			audience[i][1] = scanner.nextInt() - 1;
			
			int nexp = audience[i][1] - audience[i][0];
			if (exp < nexp) {
				expected = i;
				exp = nexp;
			}
		}
		System.out.println(expected + 1);
		
		for (int i = 0; i < N; i++) {
			for (int start = audience[i][0]; start <= audience[i][1]; start++) {
				if (cake[start] == 0) {
					cake[start] = i + 1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < L; j++) {
				if (cake[j] == i+1) {
					reality[i]++;
				}
			}
		}
		
		int winner = 0;
		int winnerpiece = 0;
		
		for (int i = 0; i < N; i++) {
			if (reality[i] > winnerpiece) {
				winner = i;
				winnerpiece = reality[i];
			}
		}
		
		System.out.println(winner + 1);
	}
}
