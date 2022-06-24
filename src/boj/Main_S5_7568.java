package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_S5_7568 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Person[] arr = new Person[N];
		int[] result = new int[N];
		int[] rank = new int[N];

		for (int i = 0; i < N; i++) {
			int height = sc.nextInt();
			int weight = sc.nextInt();
			
			arr[i] = new Person(height, weight);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (arr[i].weight < arr[j].weight && arr[i].height < arr[j].height)
					result[i]++;
			}
		}
		for (int i = 0; i < N; i++)
			System.out.print((result[i] + 1) + " ");
	}
	
	static class Person {
		int height;
		int weight;
		public Person(int height, int weight) {
			super();
			this.height = height;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Person [height=" + height + ", weight=" + weight + "]";
		}
		
	}
}
