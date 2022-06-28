package boj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main_S1_1697 {
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		visited = new boolean[100001];
		bfs(N, K);
	}

	private static void bfs(int start, int end) {
		Deque<int[]> queue = new ArrayDeque<int[]>();
		
		queue.offer(new int[] {start, 0});
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == end) {
				System.out.println(cur[1]);
				return;
			}
			visited[cur[0]] = true;
			int next1 = cur[0] - 1;
			int next2 = cur[0] + 1;
			int next3 = cur[0] * 2;
			if (next1 == end || next2 == end || next3 == end) {
				System.out.println(cur[1]+1);
				break;
			} else {
				if (next1 >= 0 && next1 <= 100000 && !visited[next1])
					queue.offer(new int[] {next1, cur[1]+1});
				if (next2 >= 0 && next2 <= 100000 && !visited[next2])
					queue.offer(new int[] {next2, cur[1]+1});
				if (next3 >= 0 && next3 <= 100000 && !visited[next3])
					queue.offer(new int[] {next3, cur[1]+1});
			}
		}
	} 
	
}
