package contact;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1238_김태하 {
	
	// bfs로 마지막으로 전달받는 그룹 인덱스를 구하고 그룹에 속한 정점을 저장할 리스트를 사용해서 해결
	
	static int N, start, lastlevel, answer;
	static boolean[][] adjarr;
	static boolean[] hasVisited;
	static ArrayList<Integer> candidate;
	
	public static void main(String[] args) throws Exception {
		int tc = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());				// 간선 자료 개수
			start = Integer.parseInt(st.nextToken()) - 1;		// 시작 정점
			lastlevel = 0;										// 마지막 차례를 구분하기 위한 인덱스
			answer = 0;											// 마지막으로 전달받는 그룹 중 가장 큰 수
			adjarr = new boolean[100][100];						// 인접 정보 배열
			hasVisited = new boolean[100];						// 방문 체크 배열
			candidate = new ArrayList<>();						// 마지막으로 전달받는 그룹을 저장할 리스트
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {					// 간선 정보를 인접 배열에 저장
				int from = Integer.parseInt(st.nextToken()) - 1;	// 0부터 시작하는 인덱스로 처리하고 싶어서 -1 해줌
				int to = Integer.parseInt(st.nextToken()) - 1;
				
				adjarr[from][to] = true;
			}
			
			bfs(start, 0);
			System.out.printf("#%d %d\n", tc++, answer + 1);
		}
		
	}

	private static void bfs(int start, int level) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {start, level});
		hasVisited[start] = true;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentlevel = current[1];
			
			if (currentlevel != lastlevel) {		// 현재 정점이 이전 정점보다 다음 단계에서 전달받는다면
				candidate.clear();					// 기존의 그룹 정보를 모두 삭제하고
				lastlevel = currentlevel;			// 현재 단계가 마지막 단계가 된다.
			}
			candidate.add(current[0]);				// 그룹에 현재 정점을 추가한다.
			
			for (int ad = 0; ad < 100; ad++) {
				if (adjarr[current[0]][ad] && !hasVisited[ad]) {
					queue.offer(new int[] {ad, current[1] + 1});
					hasVisited[ad] = true;
				}
			}
		}
		
		answer = Collections.max(candidate);
		
	}
}
