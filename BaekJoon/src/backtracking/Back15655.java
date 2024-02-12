package backtracking;

import javax.swing.plaf.synth.SynthUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back15655 {
    static int n;

    static int m;

    static boolean[] visit;

    static int[] num;

    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        result = new int[m];
        visit = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        backTracking(0);
    }

    public static int backTracking(int depth) {
        if (depth == m) {
            for (int number : result) {
                System.out.print(number + " ");
            }
            System.out.println();
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                if (depth == 0 || result[depth - 1] < num[i]) {
                    visit[i] = true;
                    result[depth] = num[i];
                    backTracking(depth + 1);
                    visit[i] = false;
                }

            }

        }
        return 1;
    }
}
