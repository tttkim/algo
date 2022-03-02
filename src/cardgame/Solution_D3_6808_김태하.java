package cardgame;

import java.util.Scanner;

public class Solution_D3_6808_김태하 {
	static int T;
	static int win, lose;
	static int[] cardK = new int[9];
	static int[] cardI = new int[9];
	static int[] order;
	static boolean[] isSelected;
	
	public static boolean isInArr(int n, int[] arr) {
		for (int num : arr) {
			if (num == n) {
				return true;
			}
		}
		return false;
	}
	
	public static void permutation(int cnt) {
		if (cnt == 9) {
			// 이겼는지 졌는지 비교하기
			int scoreK = 0;
			int scoreI = 0;
			for (int i = 0; i < 9; i++) {
				if (cardK[i] > order[i]) {
					scoreK += (cardK[i] + order[i]);
				} else if (cardK[i] < order[i]) {
					scoreI += (cardK[i] + order[i]);
				}
			}
			if (scoreK > scoreI) {
				win++;
			} else {
				lose++;
			}
			return;
		}
		
		// 순열 생성하기
		for (int i = 0; i < 9; i++) {
			if (isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			order[cnt] = cardI[i];
			
			permutation(cnt+1);
			
			isSelected[i] = false;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		T = scanner.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			order = new int[9];
			isSelected = new boolean[9];
			win = 0;
			lose = 0;
			
			for (int i = 0; i < 9; i++) {
				cardK[i] = scanner.nextInt();
			}
			
			int i = 0;
			// cardK에 들어있지 않은 수를 cardI에 넣는다.
			for (int n = 1; n <= 18; n++) {
				if (!isInArr(n, cardK)) {
					cardI[i++] = n;
				}
			}
			// cardI의 모든 순열을 고려해 시뮬레이션한다.
			// 이기는 경우의 수와 지는 경우의 수를 카운트한다.
			permutation(0);
			
			System.out.println("#" + tc + " " + win + " " + lose);
		}
		
		scanner.close();
	}
}
