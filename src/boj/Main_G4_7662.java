package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_G4_7662 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			SortedMap<Integer, Integer> pq = new TreeMap<>();
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				int val = Integer.parseInt(st.nextToken());
				if (command == 'I') {
					if (pq.containsKey(val)) {
						pq.put(val, pq.get(val) + 1);
					} else {
						pq.put(val, 1);
					}
				} else if (command == 'D') {
					if (pq.isEmpty())
						continue;
					else {
						if (val == 1) {
							int max = pq.lastKey();
							if (pq.get(max) == 1) {
								pq.remove(max);
							} else {
								pq.put(max, pq.get(max)-1);
							}
						} else {
							int min = pq.firstKey();
							if (pq.get(min) == 1) {
								pq.remove(min);
							} else {
								pq.put(min, pq.get(min)-1);
							}
						}
					}
				}
			}
			
			if (pq.isEmpty())
				sb.append("EMPTY\n");
			else {
				sb.append(pq.lastKey() + " " + pq.firstKey() + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}
