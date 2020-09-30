
public class Determine_NumberPowerOf4 {
    public static boolean isPowerOf4(int n){
         if(n<0){
            return false;
        }
        int count=0;
        
        while(n>0){
            count++;
            n=n & (n-1);
        }
        return(count%2==0);
    
    }
    public static void main(String[] args){
        System.out.println(isPowerOf4()+"");
    }
}
