package 장훈이의높은선반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, B, res;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			res = 2000000;
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			subSet(0, 1);
			subSet(arr[0], 1);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static void subSet(int sum, int i) {
		if(res == 0)
			return;
		if(sum >= B) {
			res = res < sum - B ? res : sum - B;
		}
		if(i == N)
			return;
		subSet(sum, i+1);
		subSet(sum + arr[i], i+1);
	}
}
