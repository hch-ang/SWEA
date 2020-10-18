package from0930to1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_보급로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		Queue <Node> Q = new LinkedList<Node>();
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] arr = new int[N][N];
			int[][] sig = new int[N][N];
			for(int i = 0; i < N; i++)
				Arrays.fill(sig[i], Integer.MAX_VALUE - 1);
			String tempstr;
			for(int i = 0; i < N; i++) {
				tempstr = in.readLine();
				for(int j = 0; j < N; j++)
					arr[i][j] = tempstr.charAt(j) - '0';
			}
			sig[0][0] = 0;
			Q.add(new Node(0, 0));
			Node temp;
			int r, c, rr, cc, point, npoint;
			while(!Q.isEmpty()) {
				temp = Q.poll();
				r = temp.r;
				c = temp.c;
				point = sig[r][c];
				for(int dir = 0; dir < 4; dir++) {
					rr = r + dr[dir];
					cc = c + dc[dir];
					if(rr < 0 || cc < 0 || rr >= N || cc >= N)
						continue;
					npoint = point + arr[rr][cc];
					if(sig[rr][cc] > npoint) {
						sig[rr][cc] = npoint;
						Q.add(new Node(rr, cc));
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(sig[N-1][N-1]).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
