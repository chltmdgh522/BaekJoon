import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] garde;
        List<Integer> list;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            garde = new int[201][5];
            list = new ArrayList<>();
            int cnt = 0;
            //1: 합 , 2: cnt, 3: 5번째 점수 4: 5번째 횟수 5: 6점수 방지
            for (int j = 0; j < n ; j++) {
                int input = Integer.parseInt(st.nextToken());
                list.add(input);
                garde[input][1] += 1;
            }

            for (int a = 1; a < n + 1; a++) {
                int b = list.get(a - 1);
                if (garde[b][1] == 6) {
                    if (garde[b][3] == 4 && garde[b][4] == 0) {
                        garde[b][2] = a;
                        garde[b][4] = 1;
                        continue;
                    }
                    if(garde[b][3] != 4 && garde[b][4] == 0) {
                        int r = a - cnt;
                        garde[b][0] += r;
                        garde[b][3] += 1;

                    }
                } else {
                    cnt++;
                }
            }

            int min = Integer.MAX_VALUE;
            int team = 0;
            for (int k = 1; k < 201; k++) {
                if (garde[k][1] == 6) {
                    if (garde[k][0] < min) {
                        team = k;
                        min = garde[k][0];
                    } else if (garde[k][0] == min) {
                        if (garde[k][2] < garde[team][2]) {
                            team = k;
                        }
                    }

                }
            }
            System.out.println(team);
        }
    }
}
