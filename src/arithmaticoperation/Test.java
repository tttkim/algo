package arithmaticoperation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Test {

		static int N; // 관리자 패스워드의 최댓값
		static int M; // 해커가 사용한 패스워드의 개수
		static int[] hackerpw; // 해커가 사용한 패스워드들을 저장한 배열
		
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			N = Integer.parseInt(br.readLine());	// 관리자 패스워드의 최댓값 읽어오기
			M = Integer.parseInt(br.readLine());	// 해커가 사용한 패스워드의 개수 읽어오기
			hackerpw = new int[M];	// 해커가 사용한 패스워드들을 저장한 배열 초기화
	        StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {	// 해커가 사용한 패스워드 개수만큼
				hackerpw[i] = Integer.parseInt(st.nextToken());	// 배열에 해커가 사용한 패스워드 채워넣기
			}
			
			int securitypoint = 0;	// 최대 보안성 초기화
			for (int n = 0; n <= N; n++) {	// 가능한 관리자 패스워드 각각에 대해
				int minpoint = Integer.MAX_VALUE;	// 보안척도 초기화
				for (int i = 0; i < M; i++) {		// 모든 해커가 사용한 패스워드에 대해
					minpoint = Math.min(minpoint, Integer.bitCount(hackerpw[i] ^ n));	// 보안척도 계산하기
				}
				securitypoint = Math.max(minpoint, securitypoint);	// 최대 보안성 계산하기
			}
			bw.write("" + securitypoint);
	        bw.newLine();
	        bw.flush();
	        bw.close();
		}
}
