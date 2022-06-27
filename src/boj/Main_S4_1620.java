package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_S4_1620 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<String> names = new ArrayList<>();
		Map<String, Integer> nums = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			names.add(name);
			nums.put(name, i+1);
		}
		
		for (int i = 0; i < M; i++) {
			String question = br.readLine();
			if (question.charAt(0) >= '0' && question.charAt(0) <= '9') {
				bw.write(names.get(Integer.parseInt(question) - 1));
				bw.newLine();
			} else {
				bw.write(Integer.toString(nums.get(question)));
				bw.newLine();
			}
			
		}
		bw.flush();
		bw.close();
	}
	
	

}
