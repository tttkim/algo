package set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_11723_김태하 {
	static int S;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = 0;
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			String[] temp = br.readLine().split(" ");
			String command = temp[0];
			
			if (command.equals("add")) {
				int value = Integer.parseInt(temp[1]) - 1;
				add(value);
			} else if (command.equals("remove")) {
				int value = Integer.parseInt(temp[1]) - 1;
				remove(value);
			} else if (command.equals("check")) {
				int value = Integer.parseInt(temp[1]) - 1;
				check(value);
			} else if (command.equals("toggle")) {
				int value = Integer.parseInt(temp[1]) - 1;
				toggle(value);
			} else if (command.equals("all")) {
				S = -1;
			} else {
				S = 0;
			}
		}
		
		System.out.println(sb.toString());
	}

	private static void toggle(int value) {
		if ((S & 1<<value) != 0) {
			S ^= 1<<value;
		} else {
			S |= 1<<value;
		}
		return;
	}

	private static void check(int value) {
		if ((S & 1<<value) != 0) {
			sb.append("1\n");
			return;
		}
		sb.append("0\n");
	}

	private static void remove(int value) {
		if ((S & 1<<value) != 0) {
			S ^= 1<<value;
		}
		return;
	}

	private static void add(int value) {
		S |= 1<<value;
		return;
	}
}
