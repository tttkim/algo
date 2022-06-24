package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B5_10950 {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String s = null;
		try {
			while ((s = br.readLine()) != null || s.length() > 0)  {
				st = new StringTokenizer(s);
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				System.out.println(A+B);
			}
			
		} catch (Exception e) {
			return;
		}
	}
}
