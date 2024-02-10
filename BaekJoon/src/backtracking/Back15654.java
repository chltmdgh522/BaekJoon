package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back15654 {
    static int n;

    static int m;

    static BufferedWriter bw;

    static int[] result;
    static int[] num;

    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num=new int[n];
        result=new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[n];
        Arrays.sort(num);

        backTracking(0);
        bw.flush();
        bw.close();
    }

    public static int backTracking(int depth) throws IOException {
        if (depth == m) {
            for(int a : result){
                bw.write(a+" ");
            }
            bw.write("\n");
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i]=true;
                result[depth] = num[i];
                backTracking(depth + 1);
                visit[i]=false;
            }
        }
        return 1;
    }
}
