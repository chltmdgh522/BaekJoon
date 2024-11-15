package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW20934 {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t=Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            st=new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int k= Integer.parseInt(st.nextToken());
            int place = s.indexOf("o");
            int num=i+1;
            System.out.println("#"+num+" " +solution(k, place));
        }
    }

    static int solution(int bell, int place){
        for(int i=0; i<bell; i++){
            if(place==0){
                place+=1;
            }else if(place==1){
                place-=1;
            }else{
                place-=1;
            }
        }

        return place;
    }
}
