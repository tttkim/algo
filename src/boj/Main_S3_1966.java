package boj;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_S3_1966 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for (int i = 0; i < N; i++) {
				int temp = sc.nextInt();
				queue.add(temp);
				pq.add(temp);
			}
			boolean flag = false;
			int cnt = 0;
			int priority = -1;
			while (!flag) {
				priority = pq.poll();
				while (queue.peek() < priority) {
					queue.add(queue.poll());
					M--;
					if (M == -1)
						M += queue.size();
				}
				queue.poll();
				cnt++;
				if (M == 0)
					flag = true;
				else
					M -= 1;
			}
			System.out.println(cnt);
			
			
		}
		
		
	}
}
