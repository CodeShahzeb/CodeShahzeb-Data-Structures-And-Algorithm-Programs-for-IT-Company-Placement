
public class FlippingBits {
    public static long flippingBits(long n) {
       int bits=(int) Math.floor(Math.log(n)/Math.log(2) +1);
       int m=1<<(bits-1);
        m=m | m-1 ;
       return (int)n^m;

    }
   public static void main(String args[]){
       System.out.println(flippingBits(5));
   } 
}
