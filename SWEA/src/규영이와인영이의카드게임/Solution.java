package 규영이와인영이의카드게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int count;
	static int[] arr = new int[9];
	static int[] nums1 = new int[9];
	static int[] nums2 = new int[9];
	static boolean[] sig = new boolean[19];
	static boolean[] combsig = new boolean[9];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			count = 0;
			for(int i = 1; i <= 18; i++)
				sig[i] = false;
			for(int i = 0; i < 9; i++)
				combsig[i] = false;
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i = 0; i < 9; i++) {
				nums1[i] = Integer.parseInt(st.nextToken());
				sig[nums1[i]] = true;
			}
			int idx = 0;
			for(int i = 1; i <= 18; i++) {
				if(sig[i] == false)
					arr[idx++] = i;
			}
			for(int i = 0; i < 9; i++) {
				combsig[i] = true;
				nums2[0] = arr[i];
				comb(1);
				combsig[i] = false;
			}
			System.out.println("#" + tc + " " + count + " " + (362880 - count));
		}
	}
	
	static void calc() {
//		for(int i = 0; i < 9; i++)
//			System.out.print(nums2[i] + " ");
//		System.out.println();
		
		int num1 = 0;
		int num2 = 0;
		for(int i = 0; i < 9; i++) {
			if(nums1[i] > nums2[i])
				num1 += nums1[i] + nums2[i];
			else
				num2 += nums1[i] + nums2[i];
		}
		if(num1 > num2)
			count++;
	}
	
	static void comb(int iteration) {
		if(iteration == 9) {
			calc();
			return;
		}
		for(int i = 0; i < 9; i++) {
			if(combsig[i] == false) {
				combsig[i] = true;
				nums2[iteration] = arr[i];
				comb(iteration + 1);
				combsig[i] = false;
			}
		}
	}
}
