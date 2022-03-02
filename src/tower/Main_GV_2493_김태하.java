package tower;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_GV_2493_김태하 {
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> orders = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			while (stack.size() != 0 && stack.peek() < num) {
				stack.pop();
				orders.pop();
			}
			if (stack.size() == 0) {
				sb.append("0 ");
			} else {
				sb.append(Integer.toString(orders.peek()) + " ");
			}
			stack.push(num);
			orders.push(i + 1);
		}
		System.out.println(sb);
		
	}
}
