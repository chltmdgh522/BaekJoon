class Solution {
    static boolean[] visit;
    static String num = "";
    static int answer = 0;
    static boolean flag = false;

    static String[] number;
    static boolean[] visitall;
    
    public static int solution(String numbers) {
        number = new String[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            number[i] = String.valueOf(numbers.charAt(i));
        }
        visit = new boolean[number.length];
        visitall = new boolean[9999999];
        dfs(0);
        return answer;
    }

    public static void dfs(int level) {
        flag = false;
        if (level == number.length) {
            return;
        }
        for (int i = 0; i < number.length; i++) {
            if (level == 0 && number[i].equals("0")) {
                continue;
            }
            if (!visit[i]) {
                if (num.isEmpty()  && !visitall[Integer.parseInt(number[i])] ) {
                    visit[i] = true;
                    num += number[i];
                    visitall[Integer.parseInt(num)] = true;

                } else if (!visitall[Integer.parseInt(num + number[i])]) {
                    visit[i] = true;
                    num += number[i];
                    visitall[Integer.parseInt(num)] = true;

                } else {
                    continue;
                }
            } else {
                continue;
            }

            int num_int = Integer.parseInt(num);

            if(num_int == 1){
                flag=true;
            }
            for (int j = 2; j <= Math.sqrt(num_int); j++) {
                if (num_int != 2 && num_int % j == 0) {
                    flag = true;
                    break;
                }
            }


            if (!flag) {
                answer++;

            }
            dfs(level + 1);
            num = num.substring(0, level);
            visit[i] = false;

        }

    }

}
