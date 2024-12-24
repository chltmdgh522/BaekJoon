package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Graph1991 {
    static int N;
    static String[][] node;

    static boolean[][] visit;

    static StringBuilder sb;

    static StringBuilder sb1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        node = new String[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            node[i][0] = st.nextToken();
            node[i][1] = st.nextToken();
            node[i][2] = st.nextToken();
        }


        sb = new StringBuilder();
        sb.append("A");
        preOrder("A");
        sb.append("\n");


        visit = new boolean[N][3];
        inOrder("A");
        sb.append("\n");

        sb1 = new StringBuilder();
        sb1.append("A");
        postOrder("A");
        sb.append(sb1.reverse());


        System.out.println(sb.toString());
    }

    static void preOrder(String message) {

        int preCnt2 = 0;
        for (int i = 0; i < N; i++) {
            if (node[i][0].equals(message)) {
                preCnt2 = i;
                break;
            }
        }
        for (int i = 1; i < 3; i++) {
            if (!Objects.equals(node[preCnt2][i], ".")) {
                sb.append(node[preCnt2][i]);
                preOrder(node[preCnt2][i]);

            }
        }
    }

    static void inOrder(String message) {
        int inCnt = 0;
        for (int i = 0; i < N; i++) {
            if (node[i][0].equals(message)) {
                inCnt = i;
                break;
            }
        }
        for (int i = 1; i < 3; i++) {
            if(i==1){
                if (!Objects.equals(node[inCnt][i], ".")){
                    visit[inCnt][i]=true;
                    inOrder(node[inCnt][i]);
                }

                if(node[inCnt][i].equals(".") || visit[inCnt][i]){
                    sb.append(node[inCnt][0]);
                }
            }else{
                if (!Objects.equals(node[inCnt][i], ".")){
                    inOrder(node[inCnt][i]);
                }
            }

        }
    }

    static void postOrder(String message) {
        int preCnt2 = 0;
        for (int i = 0; i < N; i++) {
            if (node[i][0].equals(message)) {
                preCnt2 = i;
                break;
            }
        }
        for (int i = 2; i > 0; i--) {
            if (!Objects.equals(node[preCnt2][i], ".")) {
                sb1.append(node[preCnt2][i]);
                postOrder(node[preCnt2][i]);
            }
        }
    }
}
