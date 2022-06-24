package codility;

import java.awt.geom.Point2D;

public class Solution_naver_4 {
	public int solution(Point2D[] A) {
        int N = A.length;
        double[][] slopeMap = new double[N][N];
        int answer = 0;
        
        for (int i = 0; i < N-1; i++) {
        	for (int j = i+1; j < N; j++) {
        		double xdiff = (A[i].x - A[j].x);
        		if (xdiff != 0)
        			slopeMap[i][j] = (A[i].y - A[j].y) / (A[i].x - A[j].x);
        		else
        			slopeMap[i][j] = Double.MAX_VALUE;
        	}
        }
        
        for (int i = 0; i < N-2; i++) {
        	for (int j = i+1; j < N-1; j++) {
        		for (int k = j+1; k < N; k++) {
        			if (slopeMap[i][j] == slopeMap[j][k])
        				answer++;
        			if (answer > 100000000) return -1;
        		}
        	}
        }
        return answer;
    }

}
