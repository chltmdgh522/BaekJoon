import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static List<Long> list;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine());
            list=new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list.add(Long.parseLong(st.nextToken()));
            }

            int num = i + 1;
            System.out.println("#" + num + " " + solution());
        }
    }

    static long solution() {
        Collections.reverse(list);
        long pre=list.get(0);
        long sell=0;
        for(int i=1; i<list.size(); i++){
            if(pre> list.get(i)){
                long sell2 = pre - list.get(i);
                sell+=sell2;
            }else{
                pre=list.get(i);
            }
        }

        return sell;
    }
}
