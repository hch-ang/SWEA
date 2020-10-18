package from0930to1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_View {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
			int res = 0;
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			int[] arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			for(int i = 2; i < N-2; i++) {
				int left = arr[i-1] > arr[i-2] ? arr[i-1] : arr[i-2];
				int right = arr[i+1] > arr[i+2] ? arr[i+1] : arr[i+2];
				int stan = left > right ? left : right;
				res += arr[i] > stan ? arr[i] - stan : 0;
			}
			
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.print(sb.toString());
	}
}
