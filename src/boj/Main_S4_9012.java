package boj;

import java.util.Scanner;
import java.util.Stack;

public class Main_S4_9012 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < T; i++) {
			boolean flag = true;
			char[] parr = sc.nextLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			int size = parr.length;
			for (int j = 0; j < size; j++) {
				if (parr[j] == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						flag = false;
						break;
					} else {
						stack.pop();
					}
				} else {
					stack.add(parr[j]);
				}
			}
			if (stack.isEmpty() && flag == true)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
