package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy1049 {
    static int n;
    static int[] sett;
    static int[] one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        sett = new int[m + m];
        one = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            sett[i] = Integer.parseInt(st.nextToken());
            one[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(m));
    }

    public static int solution(int m) {
        int[] copy_one = new int[m];
        for (int i = 0; i < one.length; i++) {
            copy_one[i] = one[i];
            one[i] *= 6;
            sett[i + m] = one[i];
        }
        Arrays.sort(copy_one);
        Arrays.sort(sett);

        if (n < 7) {
            return Math.min(sett[0], copy_one[0] * n);
        }

        int mok = n / 6;
        int reminder = n % 6;

        int result1 = sett[0] * (mok + 1);
        int result2 = sett[0] * mok + copy_one[0] * reminder;

        return Math.min(result1, result2);
    }
}
