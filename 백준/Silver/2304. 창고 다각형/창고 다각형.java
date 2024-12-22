
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<int[]> inputList = new LinkedList<>();
        List<Integer> p_point = new ArrayList<>();
        int h_point = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            if (h_point < H) {
                h_point = H;
                p_point=new ArrayList<>();
                p_point.add(L);
            }else if(h_point==H){
                p_point.add(L);
            }
            inputList.add(new int[]{L, H});
        }

        inputList.sort((e1, e2) -> {
            int key1 = e1[0];
            int key2 = e2[0];
            return key1 - key2;
        });

        int cnt = 0;
        int cnt2=0;
        for (int[] ints : inputList) {
            if (p_point.get(0) == ints[0]) {
                break;
            }
            cnt++;
        }

        for (int[] ints : inputList) {
            if (p_point.get(p_point.size()-1) == ints[0]) {
                break;
            }
            cnt2++;
        }

        int pointFront = cnt;
        int pointBack = cnt2;
        int sum = 0;

        int height_l = 0;
        int place_l = 0;
        for (int i = 0; i <= pointFront; i++) {
            int[] input = inputList.get(i);
            if (i == 0) {
                height_l = input[1];
                place_l = input[0];
            } else if (input[1] > height_l) {
                sum += (input[0] - place_l) * height_l;
                height_l = input[1];
                place_l = input[0];
            }
        }


        int height_r = 0;
        int place_r = 0;
        for (int i = N - 1; i >= pointBack; i--) {
            int[] input = inputList.get(i);
            if (i == N - 1) {
                height_r = input[1];
                place_r = input[0];
            } else if (input[1] > height_r) {
                sum += Math.abs((input[0] - place_r) * height_r);
                height_r = input[1];
                place_r = input[0];
            }
        }

        int width=Math.abs(p_point.get(0)- p_point.get(p_point.size()-1))+1;
        sum += (h_point)*width;

        System.out.println(sum);
    }
}
