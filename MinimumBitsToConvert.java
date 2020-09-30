
public class MinimumBitsToConvert {
    public static int CountSetBits(int n){
        int count=0;
        while(n>0){
            count++;
            n &=n-1;
        }
        return count;
    }
    
    public static int Flipped(int a,int b){
        return CountSetBits(a^b);
    }
    public static void main(String[] args){
        int a=10;
        int b=20;
        System.out.println(Flipped(a,b)+"");
    }
}
