package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bro7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int p;
        p = Integer.parseInt(br.readLine());

        int [][]arr=new int[p][2];
        for(int i=0; i<p; i++){
            st=new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int []rank=new int[p];

        for(int i=0; i<p; i++){
            for(int j=0; j<p; j++){
                if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]){
                    rank[i]++;
                }
            }
        }

        for(int i=0; i< rank.length; i++){
            System.out.println(rank[i]+1);
        }
    }
}

/*
* static int p;
    static int[][] arr;
    static int[][] arr_copy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        p = Integer.parseInt(br.readLine());
        arr = new int[p][2];
        arr_copy = new int[p][2];
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr_copy[i][0] = arr[i][0];
            arr_copy[i][1] = arr[i][1];
        }

        Arrays.sort(arr, (o1, o2) -> Integer.compare(o2[0], o1[0]));

        System.out.println(arr[0][0]);

        int[] solution = solution();
        for (int n : solution) {
            System.out.print(n+ " ");
        }
    }

    public static int[] solution() {
        int x = 0;
        int[] rank = new int[p];
        int[] rank_copy = new int[p];
        int cnt = 0;
        for (int i = 0; i < p; i++) {
            if (x > arr[i][1]) {
                x = arr[i][1];
                rank[i] = rank[i - 1] + 1 + cnt;
                cnt = 0;
            } else {
                if (i == 0) {
                    rank[0] = 1;
                    x = arr[i][1];
                } else {
                    rank[i] = rank[i - 1];
                    x = arr[i][1];
                    cnt++;
                }
            }
            for (int k = 0; k < p; k++) {
                if (arr[i][0] == arr_copy[k][0] && arr[i][1] == arr_copy[k][1]) {
                    rank_copy[k] = rank[i];
                    break;
                }
            }
        }

        return rank_copy;
    }*/

