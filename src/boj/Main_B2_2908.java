package boj;

import java.util.Scanner;

public class Main_B2_2908 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		
		char[] bigger = null;
		for (int i = 0; i < 3; i++) {
			if (a[3-i-1] != b[3-i-1]) {
				if (a[3-i-1] > b[3-i-1]) {
					bigger = a;
				} else {
					bigger = b;
				}
				break;
			}
		}
		
		for (int i = 2; i >= 0; i--) {
			System.out.print(bigger[i]);
		}
		
	}
}
