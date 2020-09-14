package 백만장자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int T, N;
	static int[] arr;
	static long answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			answer = 0;
			int stan = N-1;
			int max = arr[N-1];
			for(int i = N-2; i >= 0; i--) {
				if(arr[i] > max) {
					max = arr[i];
					stan = i;
				}
				else
					answer += max - arr[i];
			}

			System.out.println("#" + tc + " " + answer);
		}
	}
}
