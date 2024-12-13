package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DataStructure21921 {
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int winSum = 0;
        int cnt = 1;

        for (int i = 0; i < x; i++) {
            winSum += list.get(i);
        }

        int maxSum = winSum;

        for (int i = x; i < n; i++) {
            winSum += list.get(i) - list.get(i - x);


            if (maxSum == winSum) {
                cnt++;
            } else if (maxSum < winSum) {
                maxSum = winSum;
                cnt = 1;
            }
        }
        if (maxSum != 0) {
            System.out.println(maxSum);
            System.out.println(cnt);
        } else {
            System.out.println("SAD");
        }

    }
}
