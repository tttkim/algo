package boj;

import java.util.Scanner;

public class Main_B3_2884 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int minute = sc.nextInt();
		
		if (minute >= 45) {
			minute -= 45;
		} else {
			minute = minute - 45 + 60;
			if (hour == 0) {
				hour = 23;
			} else {
				hour -= 1;
			}
		}
		
		System.out.println(hour + " " + minute);
	}
}
