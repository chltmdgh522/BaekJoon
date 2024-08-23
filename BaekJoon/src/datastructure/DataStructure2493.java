package datastructure;

import javax.swing.plaf.nimbus.State;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DataStructure2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n; i++) {
            int top = Integer.parseInt(st.nextToken());
            boolean flag = false;
            while (!stack.isEmpty()) {
                if (stack.peek()[0] > top) {
                    sb.append(stack.peek()[1]);
                    sb.append(" ");
                    stack.push(new int[]{top,i+1});
                    flag=true;
                    break;
                }
                stack.pop();
            }
            if(!flag){
                sb.append("0 ");
                stack.push(new int[]{top,i+1});
            }
        }

        System.out.println(sb.toString().trim());

    }


}
