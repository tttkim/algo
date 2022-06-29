package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_S1_1931 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		List<Meeting> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.add(new Meeting(start, end));
		}
		
		Collections.sort(list);
		int lastMeeting = 0;
		int cnt = 0;
		for (Meeting m : list) {
			if (m.start >= lastMeeting) {
				cnt++;
				lastMeeting = m.end;
			}
		}
		System.out.println(cnt);
		
	} 
	
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		int duration;
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
			this.duration = end - start;
		}
		
		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + ", duration=" + duration + "]";
		}

		@Override
		public int compareTo(Meeting o) {
			if (this.end != o.end)
				return this.end - o.end;
			else
				return this.start - o.start;
		}
	}
}
