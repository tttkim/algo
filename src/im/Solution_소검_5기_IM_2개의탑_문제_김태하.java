package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
N개의 각기 다른 비용을 가진 블럭을 2개의 탑에 각 M1, M2 높이만큼 쌓습니다. 
M1 + M2 = N을 보장합니다.
가장 밑층은 1층입니다.
블럭을 쌓을 때 탑의 층 높이에 비례하여 비용이 증가합니다.
2개의 탑을 쌓는 데 드는 총 비용의 최소값을 계산하세요.

5개의 블럭의 비용이 다음과 같을 때,

7 4 3 5 1

총 비용은 29입니다.

1 x3
3 x2   4 x2
7 x1   5 x1
 16      13
 
N <= 50, M1 <= 50, M2 <= 50, N <= 50, 무게는 1000kg 이하

1 번째 줄에 테스트케이스 개수
2 번째 줄에 첫 번째 테스트케이스의 N, M1, M2가 순서대로 나옵니다.
3 번째 줄에 첫 번째 테스트케이스의 N개의 블럭  비용이 나옵니다.
[input]
5
5 2 3
7 3 4 1 5
7 6 1
1 2 3 4 5 6 7
9 4 5
9 8 7 6 5 4 3 2 1
20 12 8
1 1 3 3 2 2 4 4 6 6 5 5 7 7 9 9 8 8 11 11
50 31 19
61 792 207 646 338 282 952 392 161 700 552 198 694 635 725 719 868 189 537 933 448 887 22 997 177 192 327 463 664 13 76 105 396 518 702 41 713 865 748 530 946 182 318 862 637 3 872 701 975 664


결과]
#1 29
#2 63
#3 95
#4 447
#5 226521
 *
 */
public class Solution_소검_5기_IM_2개의탑_문제_김태하 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M1 = Integer.parseInt(st.nextToken());
			int M2 = Integer.parseInt(st.nextToken());
			
			int[] blocks = new int[N];
			Queue<Integer> T1 = new LinkedList<>();
			Queue<Integer> T2 = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				blocks[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(blocks);
			
			for (int i = blocks.length - 1; i >= 0;) {
				if (T1.size() < M1) {
					T1.offer(blocks[i--]);
				}
				
				if (T2.size() < M2) {
					T2.offer(blocks[i--]);
				}
			}
			
			int answer = 0;
			for (int i = 1; i <= Math.max(M1, M2); i++) {
				if (!T1.isEmpty()) {
					answer += T1.poll() * i;
				}
				
				if (!T2.isEmpty()) {
					answer += T2.poll() * i;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
		
	}//Main
	static String input="5\n" + 
			"5 2 3\n" + 
			"7 3 4 1 5\n" + 
			"7 6 1\n" + 
			"1 2 3 4 5 6 7\n" + 
			"9 4 5\n" + 
			"9 8 7 6 5 4 3 2 1\n" + 
			"20 12 8\n" + 
			"1 1 3 3 2 2 4 4 6 6 5 5 7 7 9 9 8 8 11 11\n" + 
			"50 31 19\n" + 
			"61 792 207 646 338 282 952 392 161 700 552 198 694 635 725 719 868 189 537 933 448 887 22 997 177 192 327 463 664 13 76 105 396 518 702 41 713 865 748 530 946 182 318 862 637 3 872 701 975 664\n" ; 
}//Class
