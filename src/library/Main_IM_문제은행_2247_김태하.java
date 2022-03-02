package library;

import java.util.Arrays;
import java.util.Scanner;

public class Main_IM_문제은행_2247_김태하 {
	
	static int N, start, end, withStudent, noStudent;
	static Student[] timetable;
	
	static class Student implements Comparable<Student>{
		int start;
		int end;
		
		public Student() {
			this(0, 0);
		}
		
		public Student(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Student o) {
			return this.start != o.start ? this.start - o.start : this.end - o.end;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[").append(start).append(", ").append(end).append("]");
			return builder.toString();
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		N = scanner.nextInt();
		timetable = new Student[N];
		
		for (int i = 0; i < N; i++) {
			timetable[i] = new Student(scanner.nextInt(), scanner.nextInt());
		}
		
		Arrays.sort(timetable);
		
		start = timetable[0].start;
		end = timetable[0].end;
		
		for (Student s : timetable) {
			if (s.start > end) {
				withStudent = Math.max(withStudent, end - start);
				start = s.start;
				noStudent = Math.max(noStudent, start - end);
			}
			
			if (s.end > end) {
				end = s.end;
			}
		}
		withStudent = Math.max(withStudent, end - start);
		noStudent = Math.max(noStudent, start - end);
		
		System.out.println(sb.append(withStudent).append(" ").append(noStudent).toString());
		
		
		
		scanner.close();
	}
}
