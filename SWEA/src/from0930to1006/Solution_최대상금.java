package from0930to1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_최대상금 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Node> Q = new LinkedList<Node>(); 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		int digit;
		int[] digits = new int[6];
		int[] tens = {100000, 10000, 1000, 100, 10, 1};
		for(int tc = 1; tc <= T; tc++) {
			int res = 0;
			boolean[][] visited = new boolean[1000000][10];
			StringTokenizer st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			int change = Integer.parseInt(st.nextToken());
			Q.add(new Node(num, change));
			digit = 0;
			while(num > 0) {
				digit++;
				num /= 10;
			}
			
			int stdigit = 6-digit;
			Node temp;
			int nextnum;
			while(!Q.isEmpty()) {
				temp = Q.poll();
				num = temp.num;
				change = temp.change;
				if(change%2 == 0)
					res = res > num ? res : num;
				if(change == 0)
					continue;
				for(int i = 5; i >= 0; i--) {
					digits[i] = num%10;
					num /= 10;
				}
				
				num = temp.num;
//				System.out.println("===========cur num : " + num  + " ====================");
				for(int i = stdigit; i < 5; i++) {
					for(int j = i + 1; j < 6; j++) {
						nextnum = num + digits[i]*(tens[j]-tens[i]) + digits[j]*(tens[i] - tens[j]);
//						System.out.println("next num : " + nextnum);
						if(visited[nextnum][change-1])
							continue;
//						System.out.println("통과");
						visited[nextnum][change-1] = true;
						Q.add(new Node(nextnum, change-1));
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static class Node {
		int num;
		int change;
		public Node(int num, int change) {
			this.num = num;
			this.change = change;
		}
	}
	
}
