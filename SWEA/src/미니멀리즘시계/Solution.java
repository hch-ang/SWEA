package 미니멀리즘시계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine())*2;
			sb.append("#").append(tc).append(" ").append(N/60).append(" ").append(N%60).append("\n");
		}
		System.out.print(sb.toString());
	}
}
