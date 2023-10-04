public class Test {
    public static void main(String[] args) {
        int temp=1;
        for (int i = temp; i <= 10; i++) {
            if(i==2){
                i=temp+4;
            }
            System.out.println(i);
        }
    }
}
