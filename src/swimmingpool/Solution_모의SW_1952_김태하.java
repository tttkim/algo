package swimmingpool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_모의SW_1952_김태하 {
	static int T, fee_day, fee_month, fee_tri, fee_year, minfee;
	static int[] plan;
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			T = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= T; tc++) {
				String[] temp = br.readLine().split(" ");
				fee_day = Integer.parseInt(temp[0]);
				fee_month = Integer.parseInt(temp[1]);
				fee_tri = Integer.parseInt(temp[2]);
				fee_year = Integer.parseInt(temp[3]);
				plan = new int[12];
				minfee = Integer.MAX_VALUE;
				
				temp = br.readLine().split(" ");
				
				for (int i = 0; i < 12; i++) {
					plan[i] = Integer.parseInt(temp[i]);
				}
				
				calculateFee(0, 0);
				bw.write(String.format("#%d %d\n", tc, minfee));
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void calculateFee(int month, int fee) {
		if (month >= 12) {
			minfee = Math.min(minfee, fee);
			return ;
		}
		if (fee > minfee) {
			return ;
		}
		if (plan[month] == 0) {
			calculateFee(month + 1, fee);
		} else {
			calculateFee(month + 1, fee + (fee_day * plan[month]));
				
			calculateFee(month + 1, fee + fee_month);
			
			calculateFee(month + 3, fee + fee_tri);
			
			calculateFee(month + 12, fee + fee_year);
		}
		
	}
}
