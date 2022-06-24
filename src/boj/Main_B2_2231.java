package boj;

import java.util.Scanner;

public class Main_B2_2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int pos = (int)Math.log10(N);
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int temp = i;
			int possum = 0;
			while (temp != 0) {
				possum += temp % 10;
				temp /= 10;
			}
			int res = i+possum;			// 생성자 + 각 자릿수의 합
			if (res == N && i < min)
				min = i;
		}
		if (min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);
	}
}
