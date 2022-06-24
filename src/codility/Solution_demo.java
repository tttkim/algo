package codility;

public class Solution_demo {
	public int solution(int[] A) {
		int answer = 0;
		int N = A.length;
		boolean[] arr = new boolean[1000001];
		
		for (int i = 0; i < N; i++) {
			if (A[i] < 0) {
				continue;
			}
			arr[A[i]] = true;
		}
		
		for (int i = 1; i <= 1000000; i++) {
			if (!arr[i]) {
				answer = i;
				break;
			}
		}
		
		return answer;
    }
}
