package badhairday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	// 소가 최대 80,000마리이므로 N^2이면 시간 내에 실행될 수 없다.
	// 내 헤어스타일을 볼 수 있는 소(나보다 키가 큰 소)만 스택에 유지하여 공간복잡도와 시간복잡도를 교환한다.
	
	public static void main(String[] args) throws Exception {
		Stack<Integer> stack = new Stack<>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		// 소의 키가 최대 1,000,000,000이므로 long을 사용
		Long count = 0L;
		int next;
		
		// N마리의 소를 반복하면서
		for (int i = 0; i < N; i++) {
			next = Integer.parseInt(in.readLine());
			// !stack.empty() && stack에서 나보다 작은 소를 빼줘야 한다.
			while (!stack.empty() && stack.peek() <= next) {
				stack.pop();
			}
			// stack에 현재 소를 볼 수 있는 소들만 있으므로 count 누적하기
			count += stack.size();
			// stack에 현재 소를 넣기
			stack.push(next);
		}
		
		
		
	}
}
