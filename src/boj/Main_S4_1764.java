package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_S4_1764 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (set.contains(name)) {
				cnt++;
				pq.add(name);
			}
		}
		
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			sb.append(pq.poll());
			sb.append('\n');
		}
		
		
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
	
	

}
