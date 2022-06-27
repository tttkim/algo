package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_S2_11279 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(br.readLine());
			if (cur == 0) {
				if (pq.isEmpty()) {
					bw.write("0");
				} else {
					bw.write(Integer.toString(pq.poll()));
				}
				bw.newLine();
			} else {
				pq.add(cur);
			}
		}
		
		bw.flush();
		bw.close();
		
	}
}
