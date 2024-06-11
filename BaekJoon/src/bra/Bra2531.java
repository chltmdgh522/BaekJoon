package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bra2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken())-1;

        int [] eat=new int[d];

        int [] my_eat=new int[n];

        for(int i=0; i<n; i++){
            my_eat[i]=Integer.parseInt(br.readLine())-1;
        }

        int cnt=0;
        int res=0;

        for(int i=0; i<k; i++){
            if(eat[my_eat[i]] ++ ==0){
                cnt++;
            }
        }

        for(int i=0; i<n; i++){
            if(res<=cnt){
                if(eat[c]==0){
                    res=cnt+1;
                }
                else{
                    res=cnt;
                }
            }
            int j=(i+k)%n;
            if(eat[my_eat[j]]++ ==0){
                cnt++;
            }
            if(--eat[my_eat[i]] ==0){
                cnt--;
            }
        }
        System.out.println(res);
    }
}
/*
* package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bra2531 {
    static int n;

    static int d;

    static int k;
    static int c;


    static List<Integer> list = new ArrayList<>();

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        solution();
        System.out.println(max);
    }

    private static void solution() {
        boolean[] visit = new boolean[d + 1];
        int cnt = 0;
        int start;


        for (int i = 0; i < n; i++) {
            start = list.get(0);
            for (int j = 0; j < k; j++) {
                if (!visit[list.get(j)]) {
                    visit[list.get(j)] = true;
                    cnt++;
                }
            }
            if (!visit[c]) {
                cnt++;
            }

            visit = new boolean[d + 1];
            list.remove(0);
            list.add(start);
            max = Math.max(cnt, max);
            cnt = 0;
        }

    }


}
*/