package 보호필름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int D, W, K;
			StringTokenizer st = new StringTokenizer(in.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[D][W];
			int[][] cumul = new int[D][W];
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < W; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			int num, count, fr, to;
			for(int j = 0; j < W; j++) {
				num = arr[0][j];
				count = 1;
				fr = 0;
				for(to = 1; to < D; to++) {
					if(arr[to][j] != num) {
						for(int k = fr; k < to; k++)
							cumul[k][j] = count;
						num = arr[to][j];
						fr = to;
						count = 1;
					}
					else
						count++;
				}
				for(int k = fr; k < to; k++) {
					cumul[k][j] = count;
				}
			}
			for(int i = 0; i < D; i++) {
				for(int j = 0; j < W; j++)
					System.out.print(cumul[i][j]);
				System.out.println();
			}
			System.out.println();
		}
	}
}
