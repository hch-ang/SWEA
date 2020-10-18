package from0930to1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_진기의_최고급_붕어빵 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M= Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			int idx = 0;
			int time = 0;
			String res = "Possible";
myfor:		while(idx < N) {
				time += M;
				for(int i = 0; i < K; i++) {
					if(idx == N)
						break;
					if(arr[idx] < time) {
						res = "Impossible";
						break myfor;
					}
					idx++;
				}
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.print(sb.toString());
	}
}
