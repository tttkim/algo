package snowwhite;

import java.util.Scanner;

public class Main_B2_3040_김태하 {
	static int[] input, selected;
	static boolean finished;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		input = new int[9];
		selected = new int[7];
		for (int i = 0; i < 9; i++) {
			input[i] = scanner.nextInt();
		}
		
		combination(0, 0);
		
		scanner.close();
	}
	// 9C7에서 합이 100이 되는 조합을 찾으면 출력
	
	public static void combination(int cnt, int start) {
		if (finished) {
			return;
		}
		
		if (cnt == 7) {
			int total = 0;
			for (int dwarf : selected) {
				total += dwarf;
			}
			if (total == 100) {
				for (int dwarf : selected) {
					System.out.println(dwarf);
				}
				finished = true;
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			selected[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}
		
	}
}
