import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word2 = br.readLine();
            if (word2.length() >= m) {
                // 중복 체크 최적화
                hashMap.put(word2, hashMap.getOrDefault(word2, 0) + 1);
            }
        }

        // 1. HashMap을 List로 변환
        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());

        // 2. List 정렬
        list.sort((e1, e2) -> {
            int count1 = e1.getValue();
            int count2 = e2.getValue();
            String word1 = e1.getKey();
            String word2 = e2.getKey();

            // 1. Integer 값 기준 내림차순 정렬
            if (count1 != count2) {
                return count2 - count1;
            }

            // 2. String 길이 기준 내림차순 정렬
            if (word1.length() != word2.length()) {
                return word2.length() - word1.length();
            }

            // 3. 길이가 같다면 사전순 정렬
            return word1.compareTo(word2);
        });

        // 3. StringBuilder로 출력 최적화
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            sb.append(entry.getKey()).append("\n");
        }
        System.out.print(sb);
    }
}
