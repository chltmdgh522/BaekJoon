package star;

import java.util.Scanner;

public class Star10994 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int a = num;
        int b = -1;
       int cnt=1;
       int mcnt=2;
        int l=num;
        for (int i = 1; i <= 4 * (num - 1) + 1; i++) {
            if (i % 2 == 1) {
                for(int n=1; n<cnt; n++){
                    if(n%2==1){
                        System.out.print("*");
                    }
                    else System.out.print(" ");

                }
                if(cnt==2*(num-1)+1){
                    mcnt=-2;
                }
                cnt+=mcnt;

                for (int k = 0; k < 4 * (a - 1) + 1; k++) {
                    System.out.print("*");
                }
                if (a == 1) {
                    b = 1;
                }
                a+=b;

                for(int d=4*(l-1)+1; d<4*(num-1)+1; d++){
                    System.out.print(" ");
                    System.out.print("*");
                }



            }









            else {
                for (int j = 0; j < 4 * (num - 1) + 1; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

    }
}
