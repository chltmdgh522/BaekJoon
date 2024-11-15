import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visit;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        boolean flag;
        for (int j = 0; j < n; j++) {
            flag=false;
            if (!visit[j]) {
                queue.offer(j);
            }
            while (!queue.isEmpty()) {
                flag = true;
                int temp = queue.poll();
                visit[temp] = true;

                for (int i = 0; i < n; i++) {
                    if (computers[temp][i] == 1 && !visit[i]) {
                        visit[i] = true;
                        queue.offer(i);
                    }
                }
            }
            if (flag) {
                answer++;
            }
        }


        return answer;
    }
}