package 길찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
myfor:	for(int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int[][] arr = new int[100][2];
			StringTokenizer st = new StringTokenizer(in.readLine());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < N; i++) {
				int fr = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if(arr[fr][0] > 0)
					arr[fr][1] = to;
				else
					arr[fr][0] = to;
			}
			Stack<Integer> S = new Stack<Integer>();
			S.add(0);
			int cur, next;
			while(!S.isEmpty()) {
				cur = S.pop();
				if(cur == 99) {
					sb.append(1).append("\n");
					continue myfor;
				}
				if(arr[cur][0] > 0)
					S.add(arr[cur][0]);
				if(arr[cur][1] > 0)
					S.add(arr[cur][1]);
			}
			sb.append(0).append("\n");
		}
		System.out.print(sb.toString());
	}
}
