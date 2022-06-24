package boj;

import java.util.Scanner;

public class Main_B3_4153 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int x = (int)Math.pow(sc.nextInt(), 2);
			int y = (int)Math.pow(sc.nextInt(), 2);
			int z = (int)Math.pow(sc.nextInt(), 2);
			
			if (x == 0 && y == 0 && z == 0)
				return;
			if (x + y == z || x + z == y || y + z == x) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}

		}

	}
}
