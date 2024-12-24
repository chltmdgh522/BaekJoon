package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DataStructure22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> wordMap = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            wordMap.put(word, 1);
        }

        for (int i = 0; i < M; i++) {

            String diary = br.readLine();
            String[] diary_split = diary.split(",");

            for (String s : diary_split) {
                Integer value = wordMap.get(s);
                if (value != null) {
                   wordMap.remove(s);
                }
            }

            System.out.println(wordMap.size());
         }
    }
}
