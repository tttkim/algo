package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B5_10809 {
	static int[] arr = new int[26];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Arrays.fill(arr, -1);
		char[] charr = sc.nextLine().toCharArray();
		int location = 0;
		for (char c : charr) {
			if (arr[c-'a'] == -1)
				arr[c-'a'] = location;
			location++;
		}
		
		for (int i = 0; i < 26; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
