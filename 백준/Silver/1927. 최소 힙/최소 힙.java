import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int all=Integer.parseInt(br.readLine());
        int []arr=new int[all];
        Arrays.fill(arr,-1);

        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i=0; i<all; i++){
            int n=Integer.parseInt(br.readLine());
            if(n==0 && queue.isEmpty()){
                System.out.println(0);
            }
            if(n==0 && !queue.isEmpty()){
                System.out.println(queue.poll());
            }
            if(n!=0){
                queue.add(n);
            }
        }
    }
}
