package from1007to1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_파핑파핑_지뢰찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			char[][] arr = new char[N][N];
			int[][] bomb = new int[N][N];
			boolean[][] sig = new boolean[N][N];
			for(int i = 0; i < N; i++)
				arr[i] = in.readLine().toCharArray();
			
			int r, c, rr, cc, count;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] == '*')
						bomb[i][j] = -1;
					else {
						count = 0;
						for(int dir = 0; dir < 8; dir++) {
							rr = i + dr[dir];
							cc = j + dc[dir];
							if(rr < 0 || cc < 0 || rr >= N || cc >= N)
								continue;
							if(arr[rr][cc] == '*')
								count++;
						}
						bomb[i][j] = count;
					}
				}
			}
			
			Queue <Node> Q = new LinkedList<Node>();
			int res = 0;
			Node temp;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(bomb[i][j] == 0) {
						res++;
						sig[i][j] = true;
						Q.add(new Node(i, j));
						while(!Q.isEmpty()) {
							temp = Q.poll();
							r = temp.r;
							c = temp.c;
							for(int dir = 0; dir < 8; dir++) {
								rr = r + dr[dir];
								cc = c + dc[dir];
								if(rr < 0 || cc < 0 || rr >= N || cc >= N || arr[rr][cc] == '*' || sig[rr][cc])
									continue;
								sig[rr][cc] = true;
								if(bomb[rr][cc] == 0)
									Q.add(new Node(rr, cc));
								bomb[rr][cc] = -1;
							}
						}
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 이미 0은 다 체크 했으므로
					if(bomb[i][j] > 0)
						res++;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
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
