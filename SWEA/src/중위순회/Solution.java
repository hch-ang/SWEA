package 중위순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static LinkedList<Integer>[] tree;
	static String[] strs;
	static int N;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			tree = new LinkedList[N+1];
			strs = new String[N+1];
			for(int i = 1; i <= N; i++)
				tree[i] = new LinkedList<Integer>();
			int fr, to;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				fr = Integer.parseInt(st.nextToken());
				String temp = st.nextToken();
				strs[fr] = temp;
				if(st.hasMoreTokens()) {
					to = Integer.parseInt(st.nextToken());
					tree[fr].add(to);
				}
				if(st.hasMoreTokens()) {
					to = Integer.parseInt(st.nextToken());
					tree[fr].add(to);
				}
			}
			
			dfs(1);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	
	static void dfs(int cur) {
		if(tree[cur].size() > 0)
			dfs(tree[cur].get(0));
		sb.append(strs[cur]);
		if(tree[cur].size() > 1)
			dfs(tree[cur].get(1));
	}
}
