
public class Determine_NumberPowerOf2 {
    public static boolean isPowerOfTwo(int n){
        if(n<0){
            return false;
        }
         int count=0;
        while(n>0){
            count++;
            n/=2;
        }
        return count%2==1;

    }
       public static void main(String[] args){
           System.out.println(isPowerOfTwo(2)+"");
       }
}
