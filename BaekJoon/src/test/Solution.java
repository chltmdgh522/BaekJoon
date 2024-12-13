package test;

import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        List<Integer> card = new LinkedList<>();

        int p = Integer.parseInt(br.readLine());
        for (int i = 1; i < num + 1; i++) {
            card.add(i);
        }
        int n = 0;
        for (int i = 0; i < p; i++) {
            n = Integer.parseInt(br.readLine());

            int point = 0;
            while (true) {
                List<Integer> copy = new LinkedList<>();
                copy.addAll(card);

                // 삭제 뒤에
                for (int j = num - 1 - point; j > num - 1 - point - n; j--) {
                    card.remove(card.get(j));
                }
                // 삭제 앞에
                for (int j = 0; j < n; j++) {
                    card.removeFirst();
                }


                // 앞에꺼 투입
                for (int j = num-n-n-point; j < n; j++) {
                    System.out.println(j);
                    card.add(j,copy.get(j));
                }
                for (Integer integer : card) {
                    System.out.print(integer+" ");
                }
                // 뒤에꺼 투입
                for (int j = num - n-point; j < num; j++) {

                    //card.add(j,copy.get(j));

                }

                for (Integer integer : card) {
                    System.out.print(integer+" ");
                }
                System.out.println();
                if (n * 2 > num - n * 2) {
                    return;
                } else {
                    point += (n * n);
                }


            }
        }
    }

}

