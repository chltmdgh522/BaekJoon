package bra;

public class Bra4673 {
    public static void main(String[] args) {
        boolean[] arr = new boolean[10001];
        int temp;
        arr[0] = false;
        for (int i = 1; i < arr.length; i++) {
            String num = String.valueOf(i);
            temp = i;
            for (int j = 0; j < num.length(); j++) {
                temp += (int) num.charAt(j)-'0';
            }
            if (temp < arr.length) {
                arr[temp] = true;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) {
                System.out.println(i);
            }
        }
    }
}
