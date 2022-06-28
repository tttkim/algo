package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_S2_18870 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> arr = new ArrayList<>();
		List<Integer> sortedArr = new ArrayList<>();
		
		Map<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr.add(n);
			sortedArr.add(n);
		}
		
		Collections.sort(sortedArr);
		int rank = 0;
		for (int i = 0; i < N; i++) {
			int num = sortedArr.get(i);
			if (!map.containsKey(num))
				map.put(num, rank++);
		}
		
		for (int n : arr) {
			bw.write(Integer.toString(map.get(n)));
			bw.append(' ');
		}
		bw.flush();
		bw.close();
	}
}
