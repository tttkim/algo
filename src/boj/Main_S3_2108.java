package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main_S3_2108 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int sum = 0;
		int midi = N / 2;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			int cur = sc.nextInt();
			list.add(cur);
			sum+= cur;
			if (map.containsKey(cur)) {
				map.put(cur, map.get(cur)+1);
			} else {
				map.put(cur,  1);
			}
			if (max < cur)
				max = cur;
			if (min > cur)
				min = cur;
		}
		Collections.sort(list);
		List<Integer> keylist = new ArrayList<Integer>(map.keySet());
		Collections.sort(keylist);
		int maxfreq = 0;
		int num = 0;
		boolean flag = false;
		for (int key : keylist) {
			if (map.get(key) > maxfreq) {
				maxfreq = map.get(key);
				num = key;
				flag = true;
			} else if (map.get(key) == maxfreq && flag) {
				num = key;
				flag = false;
			}
		}
		
		
		System.out.printf("%d\n", Math.round((double)sum / N));
		System.out.println(list.get(midi));
		System.out.println(num);
		System.out.println(max - min);
		
		
	}
	
	
}
