package password1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D3_1228_김태하 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int tc = 1;
			while(true) {
				int N = Integer.parseInt(br.readLine());
				StringTokenizer st = new StringTokenizer(br.readLine());
				LinkedList<String> passwords = new LinkedList<>();
				while (st.hasMoreTokens()) {
					passwords.add(st.nextToken());
				}
				int numCommand = Integer.parseInt(br.readLine());
				String command = br.readLine();
				st = new StringTokenizer(command);
				while(st.hasMoreTokens()) {
					if (st.nextToken().equals("I")) {
						int startIndex = Integer.parseInt(st.nextToken());
						if (startIndex >= 10) {
							continue;
						}
						int numOfNodes = Math.min(Integer.parseInt(st.nextToken()), 10 - startIndex);
						Stack<String> stack = new Stack<>();
						for (int i = 0; i < numOfNodes; i++) {
							stack.add(st.nextToken());
						}
						for (int i = 0; i < numOfNodes; i++) {
							if (!stack.isEmpty()) {
								passwords.add(startIndex, stack.pop());
							}
						}
					}
				}
				bw.write(String.format("#%d ", tc++));
				for (int i = 0; i < 10; i++) {
					bw.write(String.format("%s ", passwords.get(i)));
				}
				bw.newLine();
				if (!br.ready()) {
					break;
				}
			}
			bw.flush();
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
