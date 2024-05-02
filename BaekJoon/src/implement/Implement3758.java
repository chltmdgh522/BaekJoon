package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Implement3758 {

    static int n;

    static int k; //문제 갯수

    static int my; // 내팀 id

    static int m; //엔트리

    static int[] cnt;


    static int teamId;

    static int problem;

    static int score;

    static int[][] totalScore;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            my = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            cnt = new int[n];
            totalScore = new int[n][k];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                teamId = Integer.parseInt(st.nextToken());
                problem = Integer.parseInt(st.nextToken());
                score = Integer.parseInt(st.nextToken());

                if (totalScore[teamId-1][problem-1] != 0) {
                    score = Math.max(totalScore[teamId-1][problem-1], score);
                }
                totalScore[teamId-1][problem-1] = score;
                cnt[teamId-1] += 1;
                list.add(teamId);
            }
            rank();
        }

    }

    private static void rank() {

        int[][] result_score = new int[n][2];
        for (int i = 0; i < n ; i++) {
            result_score[i][0]=i+1;
            for (int j = 0; j < k; j++) {
                result_score[i][1] += totalScore[i][j];
            }
        }

        Arrays.sort(result_score, Comparator.comparingInt((int[] a) -> a[1]).reversed()); // 이차원 배열 두번째 열 기준으로 정렬

        for (int[] ints : result_score) {
            System.out.print(ints[0]);
            System.out.print(ints[1]);
            System.out.println();
        }
        int rank=0;
        for(int i=0; i<n; i++){
            if(result_score[i][0]==my){
                rank=i+1;
            }
        }


        int equal=result_score[rank-1][1];
        int my_cnt=cnt[my-1];

        for(int i=0; i<n; i++){
            if(result_score[i][1]==equal && result_score[i][0]!=my){

                if(my_cnt>cnt[result_score[i][0]-1]){
                    rank++;
                }else if (my_cnt<cnt[result_score[i][0]-1]){
                    rank--;
                } else{
                    boolean flag=false; // 값 동등일떄 빨리 나온거
                    for(int index : list){
                        if (index == result_score[i][0]) {
                            flag = true;
                            break;
                        }
                    }
                    if(flag){
                        rank++;
                    }
                }
            }
        }

        System.out.println(rank);
    }
}
