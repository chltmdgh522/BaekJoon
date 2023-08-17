package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Greedy16953 {
    static long a;
    static long b;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk=new StringTokenizer(bfr.readLine());
        long a=Long.parseLong(stk.nextToken());
        long b=Long.parseLong(stk.nextToken());
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
