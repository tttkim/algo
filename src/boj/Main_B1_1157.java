package boj;

import java.util.Scanner;

public class Main_B1_1157 {
	static int[] alpha;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		alpha = new int[26];
		
		char[] arr = sc.nextLine().toUpperCase().toCharArray();
		
		for (char c : arr) {
			alpha[c - 'A']++;
		}
		
		char answerChar = '?';
		int max = 0;
		for (int i = 0; i < 26; i++) {
			if (alpha[i] > max) {
				max = alpha[i];
				answerChar = (char)('A' + i);
			}
		}
		
		int cnt = 0;
		for (int r : alpha) {
			if (max == r)
				cnt++;
		}
		
		if (cnt > 1)
			System.out.println("?");
		else
			System.out.println(answerChar);
	}
}
