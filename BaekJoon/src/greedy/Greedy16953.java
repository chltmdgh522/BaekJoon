package greedy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Greedy16953 {
    static long a;
    static long b;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        System.out.println(bfs());
    }
    static int bfs(){
        int cnt=1;
        Queue<Long> queue=new LinkedList<>();
        queue.offer(a);
        while(!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Long temp = queue.poll();
                if (temp == b) {
                    return cnt+1;
                }

                if (temp * 2 <=b) {
                    queue.offer(temp*2);
                }
                if (temp * 10 + 1 <= b) {
                    queue.offer(temp*10+1);
                }
            }
            cnt++;
        }
        return -1;
    }
}
