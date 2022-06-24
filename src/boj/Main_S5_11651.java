package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_S5_11651 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		List<Point> arr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			arr.add(new Point(x, y));
		}
		
		Collections.sort(arr);
		
		for (Point p : arr) {
			System.out.println(p.x + " " + p.y);
		}
		
		
	}
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point o) {
			if (this.y != o.y) {
				return this.y - o.y;
			} else {
				return this.x - o.x;
			}
		}
		
	}
}
