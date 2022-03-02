package secretemail;

import java.util.Scanner;

public class Main_B1_2999_김태하 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		char[] message = scanner.nextLine().toCharArray();
		
		int N = message.length;
		
		int R = 0;
		
		for (int i = 1; i <= Math.sqrt(N); i++) {
			if (N % i == 0) {
				R = i;
			}
		}
		
		int C = N / R;
		
		char[][] arr = new char[R][C];
		
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				arr[j][i] = message[(i * R) + j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(arr[i][j]);
			}
		}
		System.out.println(sb.toString());
		
		scanner.close();
	}
}
