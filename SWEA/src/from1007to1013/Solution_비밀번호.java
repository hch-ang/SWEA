package from1007to1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc ++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			String tempstr = st.nextToken();
			Stack<Character> S = new Stack<Character>();
			char c;

			for(int i = N-1; i >= 0; i--) {
				c = tempstr.charAt(i);
				if(S.isEmpty() || S.peek() != c)
					S.add(c);
				else
					S.pop();
			}
			
			StringBuilder sb2 = new StringBuilder();
			while(!S.empty()) {
				sb2.append(S.pop());
			}
			sb.append("#").append(tc).append(" ").append(sb2.toString()).append("\n");
		}
		System.out.print(sb.toString());
	}
}
