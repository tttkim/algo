package arithmaticoperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_D4_1233_김태하 {
	static int tc = 1;
	static int numOfLines = 0;
	// 입력을 한 줄씩 받아 split한다.
	// 만약 기호라면
		// 자식이 두 개가 아니라면
			// 불가능
	// 만약 숫자라면
		// 자식이 있다면
			// 불가능
	
	public static void main(String[] args) {
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			while (true) {
				numOfLines = Integer.parseInt(br.readLine());
				
				for (int i = 0; i < numOfLines; i++) {
					String[] line = br.readLine().split(" ");
					if (isOperator(line[1])) {
						if (line.length != 4) {
							bw.write(String.format("#%d 0\n", tc++));
							for (int j = i + 1; j < numOfLines; j++) {
								br.readLine();
							}
							break;
						}
					} else {
						if (line.length != 2) {
							bw.write(String.format("#%d 0\n", tc++));
							for (int j = i + 1; j < numOfLines; j++) {
								br.readLine();
							}
							break;
						}
					}
					if (i == numOfLines - 1) {
						bw.write(String.format("#%d 1\n", tc++));
					}
				}
				if (!br.ready()) {
					break;
				}
			}
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static boolean isOperator(String s) {
		if (s.equals("+")) {
			return true;
		} else if (s.equals("-")) {
			return true;
		} else if (s.equals("*")) {
			return true;
		} else if (s.equals("/")) {
			return true;
		} else {
			return false;
		}
	}
}
