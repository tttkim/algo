package disjointset;

import java.util.Scanner;

public class Solution_D4_3289_김태하 {
	static int N, M, T;
	static int[] parents;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d ", tc);
			N = scanner.nextInt();
			M = scanner.nextInt();
			makeSet();
			for (int i = 0; i < M; i++) {
				int command = scanner.nextInt();
				int a = scanner.nextInt() - 1;
				int b = scanner.nextInt() - 1;
				
				if (command == 0) {
					union(a, b);
				} else if (command == 1) {
					System.out.print(findSet(a) == findSet(b) ? "1" : "0");  
				}
			}
			System.out.println();
		}
		scanner.close();
	}

	private static int findSet(int a) {
		if (a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

	private static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
}
