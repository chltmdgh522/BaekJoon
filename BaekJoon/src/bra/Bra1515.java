package bra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bra1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String text=br.readLine();
        int base=0;
        int point=0;
        while(base++<=30000){
            String temp=String.valueOf(base);
            for(int i=0; i<temp.length(); i++){
                if(text.charAt(point)==temp.charAt(i)){
                    point++;
                }
                if(point==text.length()){
                    System.out.println(base);
                    return;
                }
            }
        }

    }
}
