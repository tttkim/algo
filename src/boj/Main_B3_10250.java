package boj;

import java.util.Scanner;

public class Main_B3_10250 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();

			for (int i = 1; i <= W; i++) {
				for (int j = 1; j <= H; j++) {
					N--;
					if (N == 0) {
						if (i < 10)
							System.out.println(j + "0" + i);
						else {
							System.out.println(j + "" + i);
						}
						break;
					}
				}
			}
		}
	}
}
