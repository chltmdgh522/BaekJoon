package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy1931 {
    static int n;
    static int[] start;
    static int[] end;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        start = new int[n];
        end = new int[n];
        int[] endSort = new int[n];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            start[i] = s;
            end[i] = e;
            endSort[i] = end[i];
        }
        Arrays.stream(endSort).sorted();

        visited = new boolean[endSort[endSort.length - 1] + 1];
        check();
    }

    static void check() {
        int cnt = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = start[i]; j <= end[i]; j++) {
                if (visited[j]) {
                    break;
                } else {
                    visited[j] = true;
                    cnt++;
                }
            }
            if (cnt == end[i] - start[i] + 1) {
                count++;
            }
            cnt = 0;

        }
        System.out.println(count);
    }
}