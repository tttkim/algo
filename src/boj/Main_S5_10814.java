package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_S5_10814 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		List<Person> list = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		int age = 0;
		String name = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			age = Integer.parseInt(st.nextToken());
			name = st.nextToken();
//			
//			int index = 0;
//			while (index < list.size() && list.get(index).age <= age)
//				index++;
			
//			list.add(index, new Person(age, name));
			list.add(new Person(age, name));
		}
		
		Collections.sort(list);
		
		for (Person p : list) {
			bw.write(p.age + " " + p.name);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	static class Person implements Comparable<Person>{
		@Override
		public int compareTo(Person o) {
			return this.age - o.age;
		}

		int age;
		String name;
		
		public Person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person [age=" + age + ", name=" + name + "]";
		}
		
		
	}
}
