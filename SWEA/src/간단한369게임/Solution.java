package 간단한369게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int num, count;
		for(int i = 1; i <= N; i++) {
			num = i;
			count = 0;
			while(num > 0) {
				if(num%10 == 3 || num%10 == 6 || num%10 == 9)
					count++;
				num /= 10;
			}
			if(count > 0) {
				for(int c = 0; c < count; c++)
					System.out.print("-");
			}
			else
				System.out.print(i);
			System.out.print(" ");
		}
	}
}
