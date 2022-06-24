package boj;

import java.util.Scanner;

public class Main_S5_1436 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int i = 666;
		String s = null;
		while (N > 1) {
			i++;
			s = i+"";
			if (s.contains("666"))
				N--;
		}
		System.out.println(i);
	}
}
