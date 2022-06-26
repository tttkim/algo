package boj;

import java.util.Scanner;
import java.util.Stack;

public class Main_S4_10773 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		
		int K = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < K; i++) {
			int cur = sc.nextInt();
			if (cur == 0 && !stack.isEmpty()) {
				sum -= stack.pop();
				
			} else {
				sum += stack.push(cur);
			}
		}
		
		System.out.println(sum);
		
	}
	
	

}
