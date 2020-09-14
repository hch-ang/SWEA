package 보물왕태혁;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int P = Integer.parseInt(in.readLine());
			int[] arr = new int[P];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < P; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			if(P%2 == 0)
				sb.append("#").append(tc).append(" ").append((arr[P/2]*arr[P/2-1])).append("\n");
			else
				sb.append("#").append(tc).append(" ").append((arr[P/2]*arr[P/2])).append("\n");
		}
		System.out.print(sb.toString());
	}
}
