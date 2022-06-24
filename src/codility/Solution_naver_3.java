package codility;

import java.util.PriorityQueue;

public class Solution_naver_3 {
	public static void main(String[] args) {
		int N = 3;
		int[] A = {1};
		int[] B = {3};
		
		System.out.println(solution(N, A, B));
	}
	
	public static int solution(int N, int[] A, int[] B) {
		int[] freqArr = new int[N + 1];
	
		for (int i = 0; i < A.length; i++) {
			++freqArr[A[i]];
			++freqArr[B[i]];
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < freqArr.length; i++) {
			if (freqArr[i] != 0) {
				pq.add(new Node(i, freqArr[i]));
			}
		}

		int sum = 0;
		int weight = N;
		int M = pq.size();
		for (int i = 0; i < M; i++) {
			sum += (pq.poll().freq * weight--);
		}

		return sum;

	}

	public static class Node implements Comparable<Node> {
		int num;
		int freq;

		@Override
		public String toString() {
			return "Node [num=" + num + ", freq=" + freq + "]";
		}

		public Node(int num, int freq) {
			super();
			this.num = num;
			this.freq = freq;
		}

		public Node() {
			super();
		}

		@Override
		public int compareTo(Node o) {
			return o.freq - this.freq;
		}
	}
}
