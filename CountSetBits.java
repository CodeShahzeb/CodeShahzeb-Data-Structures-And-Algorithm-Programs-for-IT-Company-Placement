
public class CountSetBits {
    public static int getSetBits(int n){
        int count=0;
        while(n>0){
            count++;
            n= n & (n-1) ;
        }
        return count;
    }
   public static void main(String[] args){
         int n=6;
         System.out.println(getSetBits(n)+"");
     }
}
