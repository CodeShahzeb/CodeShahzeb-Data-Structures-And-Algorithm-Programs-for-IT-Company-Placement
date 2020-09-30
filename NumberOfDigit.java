
public class NumberOfDigit {
    public static int DecimalDigit(int n){
        int count=0;
        while(n>0){
            count++;
            n/=10;
        }
        return count;
        
    }
    
    public static int BinaryDigit(int n){
        int count=0;
        while(n>0){
            count++;
            n/=2;
        }
        return count;
    }
     public static void main(String[] args){
         System.out.println(DecimalDigit(5)+"");
     }
}
