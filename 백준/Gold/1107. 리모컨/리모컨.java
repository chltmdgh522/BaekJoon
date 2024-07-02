import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;

    static int m;

    static boolean[] visit;

    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    static int channel;

    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[10];
        
        m = Integer.parseInt(br.readLine());
        if(m!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                visit[Integer.parseInt(st.nextToken())] = true;
            }
        }
        min = Math.abs(100 - n);

        if (100 == n) {
            System.out.println(cnt);
        } else {
            solution(0);
            System.out.println(min);
        }

    }

    private static void solution(int level) {


        if (level != 0 && (sb.toString().length() == String.valueOf(n).length() ||
                sb.toString().length() == String.valueOf(n).length() - 1)) {
            channel = Integer.parseInt(sb.toString());
            cnt = sb.toString().length();
            cnt += Math.abs(n - channel);
            min = Math.min(cnt, min);
        }

        if (sb.toString().length() == String.valueOf(n).length() + 1) {
            channel = Integer.parseInt(sb.toString());
            cnt = sb.toString().length();
            cnt += Math.abs(n - channel);
            min = Math.min(cnt, min);
            return;
        }

        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                if (level != 0 || i != 0 || String.valueOf(n).length() == 1 || String.valueOf(n).length() == 2) {
                    sb.append(i);
                    solution(level + 1);
                    sb.deleteCharAt(sb.length() - 1);

                }
            }
        }

    }
}
