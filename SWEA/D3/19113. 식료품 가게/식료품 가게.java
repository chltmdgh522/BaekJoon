import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static List<Long> list;

    static boolean[] visit;

    static List<Long> item;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            visit = new boolean[n * 2];
            item = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n * 2; j++) {
                list.add(Long.parseLong(st.nextToken()));
            }
            int num = i + 1;
            solution(n);
            Collections.sort(item);
            System.out.print("#" + num);
            for (Long integer : item) {
                System.out.print(" ");
                System.out.print(integer);

            }
            System.out.println();

        }
    }

    static void solution(int n) {

        boolean flag = false;
        for (int i = n * 2 - 1; i >= 0; i--) {
            if (!visit[i] && list.get(i) % 4 == 0) {
                visit[i] = true;
                long target = list.get(i) / 4 * 3;
                for (int j = 0; j < n * 2 - 1; j++) {
                    if (!visit[j] && target == list.get(j)) {
                        visit[j] = true;
                        item.add(target);

                        break;
                    }
                }
            }
        }
    }
}
