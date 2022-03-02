package changyong;

import java.util.Scanner;

public class Solution_D4_7465_김태하 {
	static int T, N, groups;
	static int[] parents;
	
	public static void main(String[] args) {
		// 부모 노드가 자신을 가리키는 노드가 몇 개인지 세기
		
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			groups = 0;
			N = scanner.nextInt();
			makeSet();
			int M = scanner.nextInt();
			for (int i = 0; i < M; i++) {
				int a = scanner.nextInt() - 1;
				int b = scanner.nextInt() - 1;
				
				union(a, b);
			}
			
			for (int i = 0; i < N; i++) {
				if (parents[i] == i) {
					groups++;
				}
			}
			
			System.out.printf("#%d %d\n", tc, groups);
		}
		scanner.close();
	}
	
	private static int findSet(int a) {
		if (parents[a] == a) return a;
		
		return parents[a] = findSet(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) {
			return false;
		}
		
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
