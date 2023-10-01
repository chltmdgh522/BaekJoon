package bra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Bra1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(find(n));
    }
    public static int find(int n) {
        int temp;
        int temp1;
        int min;
        int cnt=0;
        int count=0;
        if (n < 100) {
            count=n;
            return count;
        }
        for (int i = 100; i <= n; i++) {
            String a = String.valueOf(i);
            temp = a.charAt(0);
            temp1= a.charAt(1);
            min=temp1-temp;
            for (int j = 2; j < a.length(); j++) {
                temp=a.charAt(j);
                if(min!=(temp-temp1)){
                    cnt=1;
                    break;
                }
            }
            if(cnt==0){
                count++;
            }else{
                cnt=0;
            }
        }
        return count+99;
    }
}
