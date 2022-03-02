package refrigerator;

import java.util.Arrays;
import java.util.Scanner;


public class Main_문제은행_1828_김태하 {
	static int N, maxTemp, numFridge;
	static Chemical[] chemicals;
	
	static class Chemical implements Comparable<Chemical>{
		int minTemp;
		int maxTemp;
		
		public Chemical() {
			this(0, 0);
		}
		
		public Chemical(int minTemp, int maxTemp) {
			super();
			this.minTemp = minTemp;
			this.maxTemp = maxTemp;
		}

		@Override
		public int compareTo(Chemical o) {
			return this.minTemp != o.minTemp ? this.minTemp - o.minTemp : this.maxTemp - o.maxTemp;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[").append(minTemp).append(", ").append(maxTemp).append("]");
			return builder.toString();
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		chemicals = new Chemical[N];
		numFridge = 1;
		
		for (int i = 0; i < N; i++) {
			chemicals[i] = new Chemical(scanner.nextInt(), scanner.nextInt());
		}
		
		Arrays.sort(chemicals);
		
		maxTemp = chemicals[0].maxTemp;
		
		for (Chemical s : chemicals) {
			if (s.minTemp > maxTemp) {
				maxTemp = s.maxTemp;
				numFridge++;
			} else {
				maxTemp = Math.min(maxTemp, s.maxTemp);
			}
		}
		
		System.out.println(numFridge);
		
		
		
		scanner.close();
	}
}
