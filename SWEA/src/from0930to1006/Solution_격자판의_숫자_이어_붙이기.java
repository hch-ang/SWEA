package from0930to1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_격자판의_숫자_이어_붙이기 {
	static HashSet<Integer> S;
	static int[][] arr = new int[4][4];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			for(int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j = 0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			S =  new HashSet<Integer>();
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++)
					comb(i, j, arr[i][j], 1);
			}
			
			sb.append("#").append(tc).append(" ").append(S.size()).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static void comb(int I, int J, int num, int count) {
		if(count == 7) {
			S.add(num);
			return;
		}
		num = num * 10;
		if(I > 0)
			comb(I - 1, J, num + arr[I - 1][J], count + 1);
		if(I < 3)
			comb(I + 1, J, num + arr[I + 1][J], count + 1);
		if(J > 0)
			comb(I, J - 1, num + arr[I][J - 1], count + 1);
		if(J < 3)
			comb(I, J + 1, num + arr[I][J + 1], count + 1);
	}

}
