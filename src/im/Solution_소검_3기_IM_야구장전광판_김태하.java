package im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_소검_3기_IM_야구장전광판_김태하 {
	/*
	 * 
	 * 4*N 크기의 디스플레이가 있다.
	 * 디스플레이는 0 또는 1의 값을 나타낼 수 있고, 최초 (k=0)에는 모든값이 0이며 시간에(k)의 흐름에 따라 디스플레이 값은 변할 수 있다.
	 * 디스플레이의 각 칸의 값이 k시간에 의해 변할 때의 조건은   칸의 수 (행+열+1)가 k의 배수일때 값이 변한다.
	 * 즉  디스플레이 i,j 번째 칸의 수인 (i+j+1)이  k의 배수이면 디스플레이 i,j의 값이 변화한다. 
	 * 0에서부터 K까지 시간이 흐를때 마지막에 디스플레에 있는 1의 개수는 몇개인가?
	 * 
	 * 예를 들어 
	 * 4*5 크기의 디스플레이가 있고  k가 3일때 디스플레이의 변화는 다음과 같다.
	 * k=0
	 * 0 0 0 0 0
	 * 0 0 0 0 0
	 * 0 0 0 0 0
	 * 0 0 0 0 0
	 * 
	 * k=1
	 * 1 1 1 1 1
	 * 1 1 1 1 1
	 * 1 1 1 1 1
	 * 1 1 1 1 1
	 * 
	 * k=2
	 * 1 0 1 0 1
	 * 0 1 0 1 0
	 * 1 0 1 0 1
	 * 0 1 0 1 0
	 * 
	 * k=3
	 * 1 0 0 0 1
	 * 0 0 0 1 1
	 * 0 0 1 1 1
	 * 0 1 1 1 0
	 * 
	 * 결과 k시간이 흐른 후의 디스플레이에 있는 1의 개수는 10이다. 
	 * 
	 * 입력 : 디스플레이의 가로크기 N, 시간 K
	 * 
	 * 제한 :
	 * 메모리 제한이 256M
	 * N의 최대값이 1000 이였고, K의 최대값은 기억이 나지 않습니다.
	 * 
[입력데이타]
7
5 3
9 4
1 2
3 4
6 7
10 11
23 40


[결과]
#1 10
#2 23
#3 2
#4 7
#5 7
#6 12
#7 15
	 */
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int cnt = 0;
			boolean[][] screen = new boolean[4][N];
			
			for (int k = 1; k <= K; k++) {
				for (int r = 0; r < 4; r++) {
					for (int c = 0; c < N; c++) {
						if ((r + c + 1) % k == 0) {
							if (screen[r][c]) {
								screen[r][c] = false;
							} else {
								screen[r][c] = true;
							}
						}
					}
				}
				
//				System.out.println("k = " + k);
//				for (int i = 0; i < 4; i++) {
//					for (int j = 0; j < N; j++) {
//						if (screen[i][j]) {
//							System.out.print("1 ");
//						} else {
//							System.out.print("0 ");
//						}
//					}
//					System.out.println();
//				}
//				System.out.println();
				
			}
			
			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < N; c++) {
					if (screen[r][c] == true) {
						cnt++;
					}
				}
			}
			
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
		
	}
}
