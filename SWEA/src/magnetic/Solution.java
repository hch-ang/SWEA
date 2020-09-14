package magnetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] arr = new int[100][100];
		int res, cur, next;
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(in.readLine());
			res = 0;
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j = 0; j < 100; j++) {
				cur = 0;
				for(int i = 0; i < 100; i++) {
					if(arr[i][j] > 0) {
						next = arr[i][j];
						if(cur == 0) {
							if(next == 1)
								cur = 1;
							else
								continue;
						}
						else if(cur == 1) {
							if(next == 1)
								continue;
							else {
								res++;
								cur = 0;
							}
						}
					}
				}
			}
			sb.append(res).append("\n");
		}
		System.out.print(sb.toString());
	}
}
