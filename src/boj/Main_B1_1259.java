package boj;

import java.util.Scanner;

public class Main_B1_1259 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			char[] num = sc.nextLine().toCharArray();
			if (num[0] == '0')
				return;
			int l = num.length;
			int boundary = l / 2;
			int i = 0;
			boolean isPalindrome = true;
			while (i <= boundary) {
				if (num[i] != num[l-1-i]) {
					isPalindrome = false;
					break;
				}
				i++;
			}
			System.out.println(isPalindrome ? "yes" : "no");
		}
		
	}
}
