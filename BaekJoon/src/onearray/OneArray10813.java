package onearray;

import java.util.Arrays;
import java.util.Scanner;

public class OneArray10813 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[2];
        for (int i = 0; i < 2; i++) {
            int num = sc.nextInt();
            a[i] = num;
        }
        int[] b = new int[a[0]];
        for(int i=0; i<b.length; i++){
            b[i]=i+1;
        }


        int[] c = new int[2];

        for (int i = 0; i < a[1]; i++) {
            for (int j = 0; j < 2; j++) {
                int num1 = sc.nextInt();
                c[j] = num1;
            }
            int[] d= Arrays.copyOf(b,b.length);
            for (int k = 0; k < a[0]; k++) {
                if (k+1 == c[0]) {
                    int x = c[1];
                    b[k]=d[x-1];
                }
                else if (k+1 == c[1]) {
                    int y=c[0];
                    b[k] = d[y-1];
                }
            }
        }

        for (int i : b) {
            System.out.print(i + " ");
        }
    }
}
