package 최빈수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int[] arr = new int[101];
		int max, num = -1;
		for(int tc = 1; tc <= T; tc++) {
			for(int i = 0; i <= 100; i++)
				arr[i] = 0;
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i = 0; i < 1000; i++) {
				arr[Integer.parseInt(st.nextToken())]++;
			}
			max = 0;
			for(int i = 0; i <= 100; i++) {
				if(arr[i] >= max) {
					max = arr[i];
					num = i;
				}
			}
			System.out.println("#" + tc + " " + num);
		}
	}
}
