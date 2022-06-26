package boj;

import java.util.Scanner;
import java.util.Stack;

public class Main_S4_4949 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		while (true) {
			boolean flag = true;
			char[] parr = sc.nextLine().toCharArray();
			if (parr[0] == '.')
				return;
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
				} else if (parr[j] == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						flag = false;
						break;
					} else {
						stack.pop();
					}
				} else if (parr[j] == '.') {
					break;
				}
				else if (parr[j] == '(' || parr[j] == '[') {
					stack.add(parr[j]);
				}
			}
			if (stack.isEmpty() && flag == true)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}

}
