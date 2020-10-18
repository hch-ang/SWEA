package from1007to1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_단순_2진_암호코드 {
	static int N, M;
	static int[][] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			char[][] arr = new char[N][M];
			for(int i = 0; i < N; i++) {
				arr[i] = in.readLine().toCharArray();
			}
			
			check = new int[N][M];
			for(int j = 0; j < M; j++) {
				int stidx = 0;
				int edidx = 0;
				char temp = arr[0][j];
				int tempnum;
				while(edidx < N) {
					if(arr[edidx][j] == temp)
						edidx++;
					else {
						if(edidx - stidx >= 5)
							tempnum = temp - '0';
						else
							tempnum = -1;
						while(stidx < edidx - 4) {
							check[stidx][j] = tempnum;
							stidx++;
						}
						tempnum = -1;
						while(stidx < edidx) {
							check[stidx][j] = tempnum;
							stidx++;
						}
						temp = arr[edidx][j];
					}
				}
				if(edidx - stidx >= 5)
					tempnum = temp - '0';
				else
					tempnum = -1;
				while(stidx < edidx - 4) {
					check[stidx][j] = tempnum;
					stidx++;
				}
				tempnum = -1;
				while(stidx < edidx) {
					check[stidx][j] = tempnum;
					stidx++;
				}
			}
			
			int res = 0;
allfor:		for(int i = 0; i < N - 4; i++) {
				for(int j = 0; j < M - 55; j++) {
					if((res = test(i, j)) > 0)
						break allfor;
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++)
					System.out.print(check[i][j] + "\t");
				System.out.println();
			}
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static int test(int I, int J) {
		int result = 0;
		for(int j = J; j < J + 56; j += 7) {
			if(check[I][j] > 0)
				return result;
			if(check[I][j + 6] == 0)
				return result;
		}
		
		int[] nums = new int[8];
		
//		00110	0	6
//		01100	1	12
//		01001	2	9
//		11110	3	30
//		10001	4	17
//		11000	5	24
//		10111	6	23
//		11101	7	29
//		11011	8	27
//		00101	9	5
		
		for(int j = 0; j < 8; j++) {
			int tempbinary = 0;
			for(int digit = J + j*7 + 1; digit < J + j*7 + 6; digit++)
				tempbinary = tempbinary*2 + check[I][digit];
			switch(tempbinary) {
			case 6:
				nums[j] = 0;
				break;
			case 12:
				nums[j] = 1;
				break;
			case 9:
				nums[j] = 2;
				break;
			case 30:
				nums[j] = 3;
				break;
			case 17:
				nums[j] = 4;
				break;
			case 24:
				nums[j] = 5;
				break;
			case 23:
				nums[j] = 6;
				break;
			case 29:
				nums[j] = 7;
				break;
			case 27:
				nums[j] = 8;
				break;
			case 5:
				nums[j] = 9;
				break;
			default:
				return 0;
			}
		}
		
		if(((nums[0] + nums[2] + nums[4] + nums[6])*3 + nums[1] + nums[3] + nums[5] + nums[7])%10 == 0)
			return nums[0] + nums[1] + nums[2] + nums[3] + nums[4] + nums[5] + nums[6] + nums[7];
		else
			return 0;
		
	}
}
