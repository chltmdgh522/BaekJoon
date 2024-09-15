import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int brown= Integer.parseInt(st.nextToken());
        int yellow=Integer.parseInt(st.nextToken());
        
        System.out.println(solution(brown,yellow));
    }
    
    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        Map<Integer, Integer> hashMap=new HashMap<>();
        int all = brown + yellow;     
        for(int i=1; i<=Math.sqrt(all); i++){
            if(all % i ==0){
                hashMap.put(all/i,i);
            }
        }
        
        
        for(Map.Entry<Integer, Integer> list : hashMap.entrySet()){
            int key= list.getKey();
            int value= list.getValue();
            int length=key *2 + value *2 -4;
            if(length == brown){
                answer=new int[]{key, value};
                break;
            }
        }
        
        
        
        return answer;
    }
}