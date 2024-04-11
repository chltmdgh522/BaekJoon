package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Implement1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt;

        HashMap<String, Integer> map = new HashMap<>();

        String[] pokemon = new String[n + 1];
        String[] solution = new String[m];
        String[] answer = new String[m];


        for (int i = 1; i < n + 1; i++) {
            pokemon[i] = br.readLine();
            map.put(pokemon[i], i);
        }
        for (int i = 0; i < m; i++) {
            solution[i] = br.readLine();
            boolean check = check(solution[i]);
            if (!check) {
                Integer num = map.get(solution[i]);
                answer[i] = String.valueOf(num);
            } else {
                answer[i] = pokemon[Integer.parseInt(solution[i])];
            }
        }
        for (String s : answer) {
            System.out.println(s);
        }

    }

    static private boolean check(String message) {
        for (int i = 0; i < message.length(); i++) {
            if (Character.isDigit(message.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
