package greedy;

import java.util.Scanner;

public class Greedy10162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int minus = -1;
        int a = 300, b = 60, c = 10;
        int ra = 0, rb = 0, rc = 0;
        int cnt = 0;

        if(t%c !=0){
            System.out.println(minus);
        }else{
            ra=t/a;
            t %=a;
            rb=t/b;
            t%=b;
            rc=t/c;
            System.out.println(ra + " " + rb + " " + rc);
        }

    }
}
