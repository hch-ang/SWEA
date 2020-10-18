package 러시아국기같은깃발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T, N, M;
		char[] line;
		int[] Warr;
		int[] Barr;
		int[] Rarr;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int result = 2500;
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			line = new char[M];
			Warr = new int[N+1];
			Barr = new int[N+1];
			Rarr = new int[N+1];
			int w, b, r;
			for(int i = 1; i <= N; i++) {
				line = in.readLine().toCharArray();
				w = 0;
				b = 0;
				r = 0;
				for(int j = 0; j < M; j++) {
					if(line[j] == 'W')
							w++;
					if(line[j] == 'B')
						b++;
					if(line[j] == 'R')
						r++;
				}
				Warr[i] = M-w + Warr[i-1];
				Barr[i] = M-b + Barr[i-1];
				Rarr[i] = M-r + Rarr[i-1];
			}

			int tempsum;
			int rfin = Rarr[N];
			for(int i = 1; i <= N-2; i++) {
				for(int j = i+1; j <= N-1; j++) {
					tempsum = Warr[i];
					tempsum += Barr[j] - Barr[i];
					tempsum += rfin - Rarr[j];
					result = result < tempsum ? result : tempsum;
				}
			}
			
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.print(sb.toString());
	}
}
