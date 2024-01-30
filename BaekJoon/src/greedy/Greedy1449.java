package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Greedy1449 {
    static int n;

    static int l;

    static float[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        arr = new float[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Float.parseFloat(st.nextToken());
        }

        System.out.println(solution());
    }

    public static int solution() {
        Arrays.sort(arr);
        int cnt = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result++;
            double x = arr[i] - 0.5 + l;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < x) {
                    cnt++;
                }
                if (j == n - 1) {
                    i = i + cnt;
                    cnt = 0;
                }
            }
        }

        return result;
    }
}
