package swea7699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char arr[][];
    static int T;
    static int R, C;
    static int res;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static Queue<Node> Q = new LinkedList<Node>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        T = Integer.parseInt(in.readLine());
        for(int tc = 1; tc <= T; tc++) {
            res = 0;
            st = new StringTokenizer(in.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            arr = new char[R][C];
            String tempstr;
            for(int i = 0; i < R; i++) {
                tempstr = in.readLine();
                for(int j = 0; j < C; j++) {
                    arr[i][j] = tempstr.charAt(j);
                }
            }
            int r, c, nextr, nextc, count;
            boolean[] sig = new boolean[26];
            boolean[] tempsig;
            sig[arr[0][0] - 'A'] = true;
            Node temp = new Node(0, 0, 1, sig);
			Q.add(temp);
            while(!Q.isEmpty()) {
                temp = Q.poll();
                r = temp.r;
                c = temp.c;
                count = temp.count;
                sig = temp.sig;
                res = res > count ? res : count;
                count++;
                for(int dir = 0; dir < 4; dir++) {
                    nextr = r + dr[dir];
                    nextc = c + dc[dir];
                    if(nextr < 0 || nextc < 0 || nextr > R-1 || nextc > C-1 || sig[arr[nextr][nextc] - 'A'])
                        continue;
                    tempsig = Arrays.copyOf(sig, 26);
                    tempsig[arr[nextr][nextc] - 'A'] = true;
                    Q.add(new Node(nextr, nextc, count, tempsig));
                }
            }
            System.out.println("#" + tc + " " + res);
        }
    }
}

class Node {
    int r;
    int c;
    int count;
    boolean[] sig;

    Node(int r, int c, int count, boolean[] sig) {
        this.r = r;
        this.c = c;
        this.count = count;
        this.sig = sig;
    }
}
