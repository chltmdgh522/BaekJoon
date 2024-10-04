class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int [] number=new int[friends.length];
        int [][] arr=new int[friends.length][friends.length];
        int max=0;
        
        for(int i=0; i<gifts.length; i++){
            String[] word=gifts[i].split(" ");
            int g=0;
            int r=0;
            
            for(int j=0; j<friends.length; j++){
                if(friends[j].equals(word[0])){
                    g=j;
                }
                if(friends[j].equals(word[1])){
                    r=j;
                }
                if(g!=0 && r!=0){
                    break;
                }
            }
            arr[g][r]+=1;
            number[r]-=1;
            number[g]+=1;
        }
        
        for(int i=0; i<friends.length; i++){
            for(int j=0; j<friends.length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
        for(int i=0; i<friends.length; i++){
            int t_max=0; 
            for(int j=0; j<friends.length; j++){
                if(i==j){
                    continue;
                }
                if(arr[i][j]==0 && arr[j][i] ==0){
                    if(number[i] > number[j]){
                        t_max+=1;
                    }else if(number[i] < number[j]){
                       
                    }
                }else{
                    if(arr[i][j] > arr[j][i]){
                        t_max+=1;
                    }else if(arr[i][j] < arr[j][i]){
                     
                    }else{
                        if(number[i] > number[j]){
                            t_max+=1;
                        }else if(number[i] < number[j]){
                           
                        }
                    }
                }
            }
            System.out.println(t_max);
            max=Math.max(max,t_max);
        }
        answer=max;
        return answer;
            
    }
}