package npuzzle;

import java.util.Scanner;

public class Main_B1_3041_김태하 {
	// 알파벳의 (현재 인덱스 / 4, 현재 인덱스 % 4)를 각각 구한 후 (현재 인덱스 / 4, 현재 인덱스 % 4)와 각각 뺀 값의 절대값의 누적합을 구한다.
	
	static char[][] map = new char[4][4];
	static int cnt;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		cnt = 0;
		
		for (int i = 0; i < 4; i++) {
			map[i] = scanner.nextLine().toCharArray();
		}
		
		for (int ab = 0; ab < 15; ab++) {
			char ch = (char)('A' + ab);
			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < 4; c++) {
					if (map[r][c] == ch) {
						cnt += Math.abs(r - ab / 4);
						cnt += Math.abs(c - ab % 4);
					}
					
				}
			}
		}
		
		System.out.println(cnt);
		
		scanner.close();
	}
	
}
