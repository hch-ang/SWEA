package 패턴마디의길이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		char[] arr;
		for(int tc = 1; tc <= T; tc++) {
			arr = in.readLine().toCharArray();
			int res;
			String stan, target;
			for(res = 1; res <= 10; res++) {
				int i = 0, j = res;
				while(j < 30) {
					if(arr[i] != arr[j])
						break;
					i = (i + 1)%res;
					j++;
				}
				if(j == 30)
					break;
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
