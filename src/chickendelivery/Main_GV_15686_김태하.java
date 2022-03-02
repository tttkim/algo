package chickendelivery;

import java.util.Scanner;

public class Main_GV_15686_김태하 {
//		도시 크기 N
	static int N;
//		남길 치킨집 조합 M
	static int M;
//		집의 위치를 저장할 배열 houseLoc[]
	static Loc[] houseLoc;
//		치킨집 위치를 저장할 배열 chickLoc[]
	static Loc[] chickLoc;
	
//		선택받은 치킨집 selected[]
	static Loc[] selected;
	
	static int houseNum, chickNum;
	
	static int[][] map;
	
//		최소 도시 치킨 거리 minCityDist
	static int minCityDist;
	
	public static class Loc{
		int r;
		int c;
		
		Loc(){
			this.r = 0;
			this.c = 0;
		}
		Loc(int r, int c){
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[").append(r).append(", ").append(c).append("] ");
			return builder.toString();
		}
	}
	
	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)){
			minCityDist = Integer.MAX_VALUE;
			N = scanner.nextInt();
			M = scanner.nextInt();
			selected = new Loc[M];
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp = scanner.nextInt();
					
					if (temp == 1) {
						houseNum++;
					} else if (temp == 2) {
						chickNum++;
					}
					map[i][j] = temp;
				}
			}
			
			houseLoc = new Loc[houseNum];
			chickLoc = new Loc[chickNum];
			
			int hi = 0;
			int ci = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						houseLoc[hi++] = new Loc(i, j);
					} else if (map[i][j] == 2) {
						chickLoc[ci++] = new Loc(i, j);
					}
				}
			}
			
			combination(0, 0);
			
			System.out.println(minCityDist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void combination(int cnt, int start) {
		if (cnt == M) {
			int CityDist = 0;
			for (int hi = 0; hi < houseNum; hi++) {
				int minHouseDist = Integer.MAX_VALUE;
				for (int ci = 0; ci < M; ci++) {
					 int houseDist = Math.abs(houseLoc[hi].r - selected[ci].r) + Math.abs(houseLoc[hi].c - selected[ci].c);
					 minHouseDist = Math.min(minHouseDist, houseDist);
				 }
				 CityDist += minHouseDist;
			}
			minCityDist = Math.min(CityDist, minCityDist);
			
			return;
		}
		
		for (int i = start; i < chickNum; i++) {	// 순서가 상관 없으므로 중복을 막기 위해 start를 점점 증가시키면서 차례대로 정렬시킨다.
											// 아예 처음부터 제외시키므로 이미 선택되었는지 여부를 확인하는 배열이 필요하지 않다.
			selected[cnt] = chickLoc[i];
			combination(cnt + 1, i + 1);	// i 대신 start가 들어가면 for문을 도는 동안은 계속 같은 값이 들어가므로 주의해야 한다.
		}
	}
}
