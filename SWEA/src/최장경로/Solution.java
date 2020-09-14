package 최장경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, res;
	static boolean[][] arr;
	static boolean[] sig;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			res = 1;
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new boolean[N+1][N+1];
			sig = new boolean[N+1];
			Queue<Integer> Q = new LinkedList<Integer>();
			int fr, to;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				fr = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				arr[fr][to] = true;
				arr[to][fr] = true;
			}
			for(int i = 1; i <= N; i++) {
				sig[i] = true;
				simul(i, 1);
				sig[i] = false;
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static void simul(int index, int count) {
		res = res > count ? res : count;
		for(int i = 1; i <= N; i++) {
			if(arr[index][i] && !sig[i]) {
				sig[i] = true;
				simul(i, count+1);
				sig[i] = false;
			}
		}
	}
}
