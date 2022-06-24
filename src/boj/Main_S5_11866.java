package boj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_S5_11866 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<Integer> list = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		System.out.print("<");
		int cur = 0;
		while (!list.isEmpty()) {
			int nr = (cur + K - 1) % list.size();
			System.out.print(list.get(nr));
			list.remove(nr);
			if (list.size() != 0) {
				System.out.print(", ");
				cur = nr % list.size();
			}
		}
		System.out.print(">");
	}
}
