package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_S4_10828 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if ("push".equals(command)) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else {
				if ("top".equals(command)) {
					if (stack.size() == 0) {
						bw.write(-1 + "");
					} else {
						bw.write(stack.peek() + "");
					}
				} else if ("pop".equals(command)) {
					if (stack.size() == 0) {
						bw.write(-1 + "");
					} else {
						bw.write(stack.pop() + "");
					}
				} else if ("size".equals(command)) {
					bw.write(stack.size() + "");
				} else if ("empty".equals(command)) {
					if (stack.isEmpty())
						bw.write(1 + "");
					else
						bw.write(0 + "");
				}
				bw.newLine();
			}
		}

		bw.flush();
		bw.close();

	}
}
