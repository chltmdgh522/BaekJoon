package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bra1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ec = 0;
        int sc = 0;
        int mc = 0;
        int cnt = 0;

        while (true) {
            ec++;
            sc++;
            mc++;
            cnt++;
            if (ec == e && sc == s && mc == m) {
                System.out.println(cnt);
                break;
            }
            if (ec == 15) {
                ec = 0;
            }
            if (sc == 28) {
                sc = 0;
            }
            if (mc == 19) {
                mc = 0;
            }
        }
    }
}
