package paintmap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_7208_김태하 {
	static int T, N, cnt;
	static int[] currentColor, answers;
	static int[][] map;
	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)){
			T = scanner.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				cnt = 0;
				N = scanner.nextInt();
				currentColor = new int[N];
				answers = new int[N];
				map = new int [N][N];
				for (int i = 0; i < N; i++) {
					currentColor[i] = scanner.nextInt();
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						map[i][j] = scanner.nextInt();
					}
				}
				for (int startNode = 0; startNode < N; startNode++) {
					bfs(startNode, N);
					answers[startNode] = cnt;
				}
				
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < N; i++) {
					min = Math.min(answers[i], min);
				}
				System.out.printf("#%d %d\n", tc, min);
				System.out.println(Arrays.toString(currentColor));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void bfs(int root, int depth) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(root);		// root 노드(BFS를 할 첫 노드)를 queue에 추가한다.
		int current;
		// queue가 empty라면 모든 노드에 대한 탐색이 종료된 상황
		// ==> queue가 empty가 아니면 계속 탐색해야 한다.
		while(!queue.isEmpty() && depth < N * N) {
			current = queue.poll();	// 부모 노드 추출하기
			
			// 모든 자식 노드를 queue에 추가하기
			for (int ad = 0; ad < N; ad++) {
				// 자식(인접) 노드 확인
				if (map[current][ad] == 1) {		// 그래프는 여기에 방문했는지 체크하는 로직만 하나 더 추가하면 된다.
					queue.offer(ad);
					if (currentColor[current] == currentColor[ad]) {
						currentColor[ad] = (currentColor[ad] + 1) > 4 ? 1 : (currentColor[ad] + 1);
						cnt++;
					}
				}
			}
			depth++;
		}
	}
}
