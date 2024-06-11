import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
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