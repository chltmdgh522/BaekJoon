package implement;

import java.util.*;
import java.io.*;

public class Implement20055 {
    static int n;

    static int k;

    static int[] arr;

    static int level = 0;

    static int[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n * 2];
        robot = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = n * 2 - 1; i > n - 1; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
        System.out.println(level);
    }

    private static void solution() {
        boolean a = true;
        while (a) {
            level++;
            // 컨베이트 벨트 이동
            int u_temp = arr[n - 1];
            int d_temp = arr[n];

            for (int i = n - 2; i >= 0; i--) {
                arr[i + 1] = arr[i];
            }
            for (int i = n; i < 2 * n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[0] = d_temp;
            arr[n * 2 - 1] = u_temp;


            // 컨베이트 벨트에서 로봇도 이동
            for (int i = n - 2; i >= 0; i--) {
                if (robot[i] != 0) {
                    robot[i + 1] = robot[i];
                    robot[i] = 0;
                }
            }

            // n번째 로봇 퇴출
            robot[n - 1] = 0;

            //로봇 자체적으로 한칸이동
            for (int i = n - 2; i >= 0; i--) {
                if (robot[i] != 0 && robot[i + 1] == 0 && arr[i + 1] > 0) {
                    robot[i + 1] = robot[i];
                    robot[i] = 0;
                    arr[i + 1] -= 1;

                }
            }

            // 로봇 탑승
            if (arr[0] > 0 && robot[0] == 0) {
                arr[0] -= 1;
                robot[0] = 1;
            }

            int strong = 0;
            for (int i : arr) {
                if (i <= 0) {
                    strong++;
                }
            }
            if (strong >= k) {
                a = false;
            }


        }
    }
}
