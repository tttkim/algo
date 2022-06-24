package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_S4_10816 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		Map<Integer, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());;
			if (map.containsKey(temp)) {
				int curcnt = map.get(temp);
				map.remove(temp);
				map.put(temp, curcnt + 1);
			} else {
				map.put(temp, 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			bw.write(map.containsKey(num) ? map.get(num) + "" : 0 + "");
			bw.write(" ");
		}
		
		bw.flush();
		bw.close();
		
	}
}
