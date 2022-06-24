package boj;

import java.util.Scanner;

public class Main_B2_1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] s = sc.nextLine().trim().split(" ");
		
		int i = 0;
		while (i < s.length && s[i].isEmpty()) {
			i++;
		}
		System.out.println(s.length - i);
	}
}
