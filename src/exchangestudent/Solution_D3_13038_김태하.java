package exchangestudent;

import java.util.Scanner;

public class Solution_D3_13038_김태하 {
	static int N;
	static int[] week = new int[7];
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = scanner.nextInt();
			
			for (int i = 0; i < 7; i++) {
				week[i] = scanner.nextInt();
			}
			
			int min = Integer.MAX_VALUE;
			
			System.out.println("#" + tc + " ");
		}
		
		scanner.close();
	}
}
