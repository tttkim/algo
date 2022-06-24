package boj;

import java.util.Scanner;

public class Main_B1_2775 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int floor = sc.nextInt();
			int line = sc.nextInt();
			int[][] apt = new int[floor+1][line+1];
			
			for (int i = 0; i < floor+1; i++) {
				for (int j = 0; j < line+1; j++) {
					if (i == 0) {
						apt[i][j] = j;
					} else {
						if (j < 1) {
							apt[i][j] = j;
						} else {
							apt[i][j] = apt[i][j-1] + apt[i-1][j]; 
						}
					}
				}
			}
			
			System.out.println(apt[floor][line]);
		}
	}
}
