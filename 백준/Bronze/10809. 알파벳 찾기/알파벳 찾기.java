import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int[] alphabet = new int[26];

        Arrays.fill(alphabet, -1);

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int order = c - 97;

            if (alphabet[order] == -1) {
                alphabet[order] = i;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i : alphabet) {
            sb.append(i + " ");
        }

        System.out.println(sb.toString().trim());
    }

}
