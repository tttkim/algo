package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_S4_10866 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		List<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if ("push".equals(command)) {
				queue.add(Integer.parseInt(st.nextToken()));
			} else {
				if ("front".equals(command)) {
					if (queue.size() == 0) {
						bw.write(-1 + "");
					} else {
						bw.write(queue.get(0) + "");
					}
				} else if ("back".equals(command)){
					if (queue.size() == 0) {
						bw.write(-1 + "");
					} else {
						bw.write(queue.get(queue.size()-1) + "");
					}
				} else if ("pop".equals(command)) {
					if (queue.size() == 0) {
						bw.write(-1 + "");
					} else {
						bw.write(queue.remove(0) + "");
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
