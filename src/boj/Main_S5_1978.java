package boj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_S5_1978 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		Set<Integer> set = new HashSet<>();
		set.add(2);
		set.add(3);
		set.add(5);
		set.add(7);


		for (int n = 11; n < 1000; n++) {
			if (n % 2 == 0)
				continue;
			int sqrt = (int) Math.sqrt(n);
			for (int i = 2; i <= sqrt; i++) {
				if (n % i == 0)
					break;
				if (i == sqrt)
					set.add(n);
			}
		}
		
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (set.contains(sc.nextInt()))
				cnt++;
		}
		System.out.println(cnt);

	}
}
