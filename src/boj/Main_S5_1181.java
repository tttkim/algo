package boj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Main_S5_1181 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<Word> pq = new PriorityQueue<>();
		Set<String> set = new HashSet<>();
		
		int N = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			set.add(sc.nextLine());
		}
		
		List<String> arr = new ArrayList<>(set);
		for (String s : arr) {
			pq.add(new Word(s));
		}
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			System.out.println(pq.poll().contents);
		}
	}
	
	static class Word implements Comparable<Word>{
		@Override
		public int compareTo(Word o) {
			if (o.len != this.len)
				return this.len - o.len;
			else
				return this.contents.compareTo(o.contents);
		}
		
		String contents = null;
		int len = 0;
		public Word() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Word(String contents) {
			super();
			this.contents = contents;
			this.len = contents.length();
		}
		@Override
		public String toString() {
			return "Word [contents=" + contents + ", len=" + len + "]";
		}
		
		
	}
}
