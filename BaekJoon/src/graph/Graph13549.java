package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Graph13549 {
    static int n;
    static int k;
    static int cnt = 0;
    static int min = Integer.MAX_VALUE;

    static char[] sign;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        sign=new char[3];

        sign[0]='+';
        sign[1]='-';
        sign[2]='*';

        dfs(n);
        System.out.println(min);
    }

    private static int dfs(int num) {

        if (num == k) {
            min=Math.min(min,cnt);
            return 1;
        }


        return 1;

    }

}

/*
* private static int dfs(int num) {

        if (num == k) {
            min=Math.min(min,cnt);
            return 1;
        }
        if (num > k) {
            cnt++;
            num -= 1;
            dfs(num);
        } else {
            int temp = k % num;
            if (k / n > 1 || temp > n / 2) {
                num *= 2;
                dfs(num);
            } else {
                num += 1;
                cnt++;
                dfs(num);
            }
        }
        return 1;

    }*/