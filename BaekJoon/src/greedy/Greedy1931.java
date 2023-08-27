package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Greedy1931 {

    static int n;
    static int[][] time;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        time=new int[n][2];
        for(int i=0; i<n; i++){
            time[i][0]=sc.nextInt();
            time[i][1]=sc.nextInt();
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        check();

    }

    static void check() {
        int preTime=0;
        int cnt=0;

        for(int i=0; i<n; i++){
            if(preTime<=time[i][0]){
                preTime=time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);


    }
}