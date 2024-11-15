
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for(int i=1; i<11; i++){
            int cnt=Integer.parseInt(br.readLine());
            list=new LinkedList<>();
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<100; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list, Comparator.reverseOrder());

            System.out.println("#"+i+" "+ solution(cnt));

        }
    }

    private static int solution(int cnt){
        int answer=0;

        for(int i=0; i<cnt; i++){
            if(list.get(0) - list.get(99) ==1 || list.get(0) - list.get(99) ==0){
                break;
            }
            list.set(0,list.get(0)-1);
            list.set(list.size()-1,list.get(99)+1);
            Collections.sort(list,Comparator.reverseOrder());
        }


        answer=list.get(0)- list.get(99);
        return answer;
    }
}
