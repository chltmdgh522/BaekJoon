package onearray;

import java.util.Scanner;

public class OneArray10807 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num1 = sc.nextInt();
        int[] a=new int[num1];

        for(int i=0; i<a.length; i++) {
            int num2 = sc.nextInt();
            a[i]=num2;
        }

        int num3=sc.nextInt();
        int cnt=0;
        for (int j : a) {
            if (j == num3) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
