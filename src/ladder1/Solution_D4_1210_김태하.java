package ladder1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution_D4_1210_김태하 {
	static int tc, start, end;
	static char[][] map;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			while (true) {
				tc = Integer.parseInt(br.readLine());
				map = new char[100][];
				for (int i = 0; i < 100; i++) {
					map[i] = br.readLine().replaceAll(" ", "").toCharArray(); 
				}
				for (int i = 0; i < 100; i++) {
					if (map[99][i] == '2') {
						end = i;
					}
				}
				move(99, end);
				
				bw.write(String.format("#%d %d\n", tc, start));

				if (!br.ready()) {
					break;
				}
			}
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void move(int r, int c) {
		if (r == 0) {
			start = c;
			return;
		}
		if (c > 0 && map[r][c-1] == '1') {
			while (c > 0 && map[r][c-1] == '1') {
				c--;
			}
			move(r-1, c);
			return;
		}
		if (c < 99 && map[r][c+1] == '1') {
			while (c < 99 && map[r][c+1] == '1') {
				c++;
			}
			move(r-1, c);
			return;
		}
		move(r-1, c);
		return;
	}
}
