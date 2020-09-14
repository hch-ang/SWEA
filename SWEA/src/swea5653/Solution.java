package swea5653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static List<Node> list = new LinkedList<Node>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[500][500];
			list.clear();
			for(int i = 250; i < 250 + N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 250; j < 250 + M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] > 0)
						list.add(new Node(i, j, arr[i][j], arr[i][j], true));
				}
			}
			
			int r, c, rr, cc, sleep, awake;
			boolean flag;
			Node temp;
			Iterator<Node> iter;
			for(int k = 0; k < K; k++) {
				int len = list.size();
				for(int i = 0; i < len; i++) {
					temp = list.get(i);
					r = temp.r;
					c = temp.c;
					sleep = temp.sleep;
					awake = temp.awake;
					if(sleep > 0)
						temp.sleep--;
					else {
						if(temp.flag) {
							temp.flag = false;
							for(int dir = 0; dir < 4; dir++) {
								rr = r + dr[dir];
								cc = c + dc[dir];
								if(arr[rr][cc] == 0) {
									arr[rr][cc] = arr[r][c];
									list.add(new Node(rr, cc, arr[r][c], arr[r][c], true));
								}
							}
						}
						if(--temp.awake == 0) {
							arr[r][c] = -1;
							iter = list.iterator();
							while(iter.hasNext()) {
								if(iter.next() == temp)
									list.remove(i);
							}
						}
					}
				}
			}
			
			int result = 0;
			for(int i = 0; i < 500; i++) {
				for(int j = 0; j < 500; j++) {
					if(arr[i][j] > 0)
						result++;
				}
			}
			
			for(int i = 230; i < 270; i++) {
				for(int j = 230; j < 270; j++)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}
			
			System.out.println(result);
		}
	}
	
	
	static class Node {
		int r;
		int c;
		int sleep;
		int awake;
		boolean flag;
		
		Node(int r, int c, int sleep, int awake, boolean flag) {
			this.r = r;
			this.c = c;
			this.sleep = sleep;
			this.awake = awake;
			this.flag = flag;
		}
	}
}
