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
        List<Integer> copy_one = new ArrayList<>();
        for (int i = 0; i < one.length; i++) {
            copy_one.add(one[i]);
            one[i] *= 6;
            sett[i + m] = one[i];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sett.length; i++) {
            list.add(sett[i]);
        }
        Collections.sort(list);
        Collections.sort(copy_one);

        if (n < 7) {
            int min= Math.min(list.get(0),copy_one.get(0)*n);
            return min;
        }

        int mok = n / 6;
        int reminder = n % 6;

        int result1 = list.get(0) * (mok + 1);
        int result2 = list.get(0) * mok + copy_one.get(0) * reminder;
        return Math.min(result1, result2);

    }
}
