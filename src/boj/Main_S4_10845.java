package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S4_10845 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		Deque<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if ("push_back".equals(command)) {
				queue.addLast(Integer.parseInt(st.nextToken()));
			} else if ("push_front".equals(command)) {
				queue.addFirst(Integer.parseInt(st.nextToken()));
			} else {
				if ("front".equals(command)) {
					if (queue.size() == 0) {
						bw.write(-1 + "");
					} else {
						bw.write(queue.peekFirst() + "");
					}
				} else if ("back".equals(command)){
					if (queue.size() == 0) {
						bw.write(-1 + "");
					} else {
						bw.write(queue.peekLast() + "");
					}
				} else if ("pop_front".equals(command)) {
					if (queue.size() == 0) {
						bw.write(-1 + "");
					} else {
						bw.write(queue.pollFirst() + "");
					}
				} else if ("pop_back".equals(command)) {
					if (queue.size() == 0) {
						bw.write(-1 + "");
					} else {
						bw.write(queue.pollLast() + "");
					}
				} else if ("size".equals(command)) {
					bw.write(queue.size() + "");
				} else if ("empty".equals(command)) {
					if (queue.isEmpty())
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
