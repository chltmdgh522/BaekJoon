package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class SW3752 {

    static int[] dp;

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i < t + 1; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[n];
            st = new StringTokenizer(br.readLine());
            set.clear();
            set.add(0);
            for (int j = 0; j < n; j++) {
                dp[j] = Integer.parseInt(st.nextToken());
                solution(dp[j]);
            }
            System.out.println("#" + i + " " + set.size());
        }
    }

    static void solution(int num) {
        Set<Integer> temp = new HashSet<>();
        temp.addAll(set);
        Iterator<Integer> iterator = temp.iterator();
        while (iterator.hasNext()) {
            set.add(iterator.next() + num);
        }
    }
}
