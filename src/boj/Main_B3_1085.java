package boj;

import java.util.Scanner;

public class Main_B3_1085 {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int min = x;
		
		if (y < min)
			min = y;
		if (w-x < min)
			min = w-x;
		if (h-y < min)
			min = h-y;
		
		System.out.println(min);
		
	}
}
