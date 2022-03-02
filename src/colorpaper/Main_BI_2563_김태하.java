package colorpaper;

import java.util.Scanner;

public class Main_BI_2563_김태하 {
	static int numPaper, cnt;
	static int[][] background;
	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)){
			numPaper = scanner.nextInt();
			cnt = 0;
			background = new int[100][100];
			
			for (int i = 0; i < numPaper; i++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				
				paste(x, y);
				
			}
			
			for (int k = 0; k < 100; k++) {
				for (int j = 0; j < 100; j++) {
					if (background[k][j] == 1) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void paste(int x, int y) {
		for (int i = 0; i < 10; i++) {
			for (int j =0; j < 10; j++) {
				if (background[y + i][x + j] != 1) {
					background[y + i][x + j] = 1;
				}
			}
		}
	}
}
