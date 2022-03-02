package searching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main_P5_1786_김태하 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		
		// 부분 일치 테이블 만들기
		int[] patternTable = new int[P.length];
		for (int i = 1, j = 0; i < P.length; i++) {	// i : 접미사 포인터, j : 접두사 포인터
			while (j > 0 && P[i] != P[j]) {
				j = patternTable[j - 1];
			}
			
			if (P[i] == P[j]) {
				patternTable[i] = ++j;
			} else {
				patternTable[i] = 0;
			}
		}
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// i : 텍스트 포인터, j : 패턴 포인터
		for (int i = 0, j = 0; i < T.length; ++i) {
			while (j > 0 && T[i] != P[j]) {
				j = patternTable[j - 1];
			}
			
			if (T[i] == P[j]) {
				if (j == P.length - 1) {
					cnt++;
					list.add((i + 1) - P.length);
					j = patternTable[j];
				} else {
					j++;
				}
			}
		}
		
		bw.write(cnt+"");
		bw.newLine();

		for (int e : list) {
			bw.write((e + 1) + " ");
		}
		bw.flush();
		bw.close();
	}
}
