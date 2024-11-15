
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static int[][] map;

	static boolean[][] visit;

	static Queue<int[]> queue;
	static int cnt = 1;

	static int switch_cnt = 1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i < t + 1; i++) {
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visit = new boolean[n][n];
			cnt = 1;
			switch_cnt = 1;

			solution(n);

			System.out.println("#" + i);

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					System.out.print(map[j][k]);
					if (k != n - 1) {
						System.out.print(" ");
					}
				}
	
					System.out.println();
	
			}
		}
	}

	private static void solution(int n) {
		int dx = 0;
		int dy = 1;
		map[0][0] = cnt;
		visit[0][0] = true;

		queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });

		if (n != 1) {
			while (!queue.isEmpty()) {
				int[] temp = queue.poll();
				int nx = dx + temp[0];
				int ny = dy + temp[1];

				cnt++;

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny]) {
					solution2(nx, ny);

				} else {
					switch_cnt++;
					if (switch_cnt == 1) {
						dx = 0;
						dy = 1;
					}
					if (switch_cnt == 2) {
						dx = 1;
						dy = 0;
					}
					if (switch_cnt == 3) {
						dx = 0;
						dy = -1;
					}
					if (switch_cnt == 4) {
						dx = -1;
						dy = 0;
					}
					if (switch_cnt == 5) {
						dx = 0;
						dy = 1;

						switch_cnt = 1;
					}

					nx = dx + temp[0];
					ny = dy + temp[1];

					solution2(nx, ny);
				}
			}
		}
	}

	private static void solution2(int nx, int ny) {

		if (!visit[nx][ny]) {

			visit[nx][ny] = true;
			map[nx][ny] = cnt;
			queue.add(new int[] { nx, ny });
		}
	}

}
