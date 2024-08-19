package datastructure;

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
        StringBuilder sb=new StringBuilder();

        for(int i=1; i<=n; i++){
            int height=Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek()[1] > height){
                    sb.append(stack.peek()[0]+" ");
                    break;
                }
                stack.pop();

            }

            if(stack.isEmpty()){
                sb.append("0 ");
            }

            stack.push(new int[]{i, height});
        }

        System.out.println(sb.toString().trim());

    }


}
