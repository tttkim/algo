package boj;

import java.util.Scanner;

public class Main_B5_1330 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int result = a - b;
		
		if (result < 0)
			System.out.println("<");
		else if (result == 0)
			System.out.println("==");
		else
			System.out.println(">");
	}
}
