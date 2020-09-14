package Base64Decoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		char[] arr;
		Base64.Decoder dec = Base64.getDecoder();
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			String text = in.readLine();
			byte target[] = text.getBytes();
			System.out.println("#" + tc + " " + new String(dec.decode(target)));
		}
	}
}
