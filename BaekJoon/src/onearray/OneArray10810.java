package onearray;

import java.util.Scanner;

public class OneArray10810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int []a=new int[2];
        for (int i = 0; i < 2; i++) {
            int num = sc.nextInt();
            a[i]=num;
        }

        int []b=new int[3];
        int []result=new int[a[0]];
        for(int i=0; i<a[1]; i++){
            for(int j=0; j<3; j++){
                int num1=sc.nextInt();
                b[j]=num1;
            }
            for(int k=b[0]; k<=b[1]; k++){
                result[k-1]=b[2];
            }
        }

        for(int d:result){
            System.out.print(d+" ");
        }
    }

}
