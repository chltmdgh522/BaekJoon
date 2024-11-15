
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static Map<Integer, Integer> map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i < t + 1; i++) {
			map = new LinkedHashMap<Integer, Integer>();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 1000; j++) {
				int num = Integer.parseInt(st.nextToken());
				map.put(num, map.getOrDefault(num, 0) + 1);

			}
			int a=solution();

			
			System.out.println("#" + n + " " + a);
		}
	}

	private static int solution() {
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

		list.sort((e1, e2) -> {
			int value1 = e1.getValue();
			int value2 = e2.getValue();

			if (value1 != value2) {
				return value2 - value1; // 내림차순
			}

			return e2.getKey().compareTo(e1.getKey());
		});
		
		return list.get(0).getKey();
				

	}

}
