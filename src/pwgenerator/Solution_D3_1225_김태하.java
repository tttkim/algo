package pwgenerator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D3_1225_김태하 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String tc;
		while ((tc = br.readLine()) != null && tc.length() > 0) {
			Queue<Integer> Q = new LinkedList<>();
			String[] tokens = br.readLine().split(" ");
			for (String token : tokens) {
				Q.add(Integer.parseInt(token));
			}
			int temp = 1;
			int n = 0;
			while (temp > 0) {
				temp = Q.poll() - ++n;
				if (temp < 0) {
					temp = 0;
				}
				if (n == 5) {
					n = 0;
				}
				Q.add(temp);
			}
			bw.write(String.format("#%s " , tc));
			for (int j = 0; j < 8; j++) {
				bw.write(String.format("%d " , Q.poll()));
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
