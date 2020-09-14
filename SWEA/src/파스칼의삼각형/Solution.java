package 파스칼의삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[][] arr = new int [11][11];
		arr[0][0] = 1;
		for(int i = 0; i < 11; i++) {
			arr[i][0] = 1;
			arr[i][i] = 1;
			for(int j = 1; j < i; j++)
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
		}
			
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");
			int N = Integer.parseInt(in.readLine());
			for(int i = 0; i < N; i++) {
				sb.append(arr[i][0]);
				for(int j = 1; j <= i; j++)
					sb.append(" ").append(arr[i][j]);
				sb.append("\n");
			}
		}
		
		System.out.print(sb.toString());
	}
}
