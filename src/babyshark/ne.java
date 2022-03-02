package babyshark;

public class ne {
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.StringTokenizer;

	public class Main {
		static int N;		// 맵 크기
		static int M;		// 물고기의 수
		static int[][] map;
		static int[] dr = {-1, 1, 0, 0};
		static int[] dc = {0, 0, -1, 1};
		static boolean isFinished;
		static boolean[][] visited;
		static int curr, curc, seconds, exp, size;
		
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			curr = 0;
			curc = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 9) {
						curr = i;
						curc = j;
						map[i][j] = 0;
					}
				}
			}
			
			seconds = 0;
			size = 2;
			
			while (!isFinished) {
				findTarget();									// 먹잇감 찾기
			}
			
			System.out.println(seconds);
		}

		private static void findTarget() {
			ArrayList<int[]> candidate = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] < size && map[i][j] > 0) {
						candidate.add(new int[] {i, j, getDist(i, j, 0)});
					}
				}
			}
			
			if (candidate.isEmpty()) {
				isFinished = true;
				return;
			}
			
			candidate.sort((a, b) -> a[2] != b[2] ? a[2] - b[2] : a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
			
			int[] target = candidate.get(0);
			
			eat(target[0], target[1]);
			seconds += target[2];
			curr = target[0];
			curc = target[1];
			
			return;
		}
		

		private static int getDist(int targetr, int targetc, int level) {
			Queue<int[]> queue = new LinkedList<>();
			
			queue.offer(new int[] {curr, curc, level});
			visited[curr][curc] = true;
			
			while (!queue.isEmpty()) {
				int[] current = queue.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = current[0] + dr[i];
					int nc = current[1] + dc[i];
					
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] <= size && !visited[nr][nc]) {
						if (nr == targetr && nc == targetc) {
							resetVisited();
							return current[2] + 1;
						}
						
						queue.offer(new int[] {nr, nc, current[2] + 1});
						visited[nr][nc] = true;
					}
				}
			}
			return Integer.MAX_VALUE;
		}

		private static void eat(int targetr, int targetc) {
			if (++exp >= size) {
				exp = 0;
				size++;
			}
//			System.out.println("Ate " + targetr + " " + targetc + "!! size : " + size + " exp : " + exp );
			map[targetr][targetc] = 0;
		}
		
		private static void resetVisited() {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited[i][j] = false;
				}
			}
		}
	}
}
