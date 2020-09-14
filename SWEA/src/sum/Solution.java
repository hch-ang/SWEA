package sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int max, tempmax;
		int[][] arr = new int[100][100];
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(in.readLine());
			max = 0;
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < 100; i++) {
				tempmax = 0;
				for(int j = 0; j < 100; j++)
					tempmax += arr[i][j];
				max = max > tempmax ? max : tempmax;
				tempmax = 0;
				for(int j = 0; j < 100; j++)
					tempmax += arr[j][i];
				max = max > tempmax ? max : tempmax;
			}
			tempmax = 0;
			for(int i = 0; i < 100; i++)
				tempmax += arr[i][i];
			max = max > tempmax ? max : tempmax;
			tempmax = 0;
			for(int i = 0; i < 100; i++)
				tempmax += arr[i][99-i];
			max = max > tempmax ? max : tempmax;
			
			sb.append(max).append("\n");
		}
		System.out.print(sb.toString());
	}
}
