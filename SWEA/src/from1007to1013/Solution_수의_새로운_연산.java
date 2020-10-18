package from1007to1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_수의_새로운_연산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 141*142/2 = 20022/2 = 10011
		int[] sums = new int[300];
		int tempsum = 0;
		for(int i = 0; i < 300; i++) {
			tempsum += i;
			sums[i] = tempsum;
//			System.out.println("i : " + i + ", sum : " + sums[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			int x1 = 0;
			while(num1 > sums[x1])
				x1++;
			int y1 = sums[x1] - num1;
			x1 -= y1;
			y1++;

			int x2 = 0;
			while(num2 > sums[x2])
				x2++;
			int y2 = sums[x2] - num2;
			x2 -= y2;
			y2++;
			
			int x = x1 + x2;
			int y = y1 + y2;
			
			int diff = y - 1;
			x += diff;
			int res = sums[x] - diff;
//			System.out.println(x1 + ", " + y1 + " and " + x2 + ", " + y2);
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
