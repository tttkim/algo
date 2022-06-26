package boj;

import java.util.Scanner;
import java.util.Stack;

public class Main_S2_1874 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cur = 1;
		boolean isAvailable = true;
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int elem = sc.nextInt();
			
			while (cur <= elem) {
				stack.push(cur++);
				sb.append("+\n");
			}
			
			if (stack.peek() == elem) {
				stack.pop();
				sb.append("-\n");
			} else {
				isAvailable = false;
				break;
			}
		}
		
		if (!isAvailable)
			System.out.println("NO");
		else
			System.out.println(sb.toString());

	}
}
