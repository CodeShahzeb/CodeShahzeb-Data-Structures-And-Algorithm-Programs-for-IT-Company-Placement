
public class CheckSetBit {
    public static void main(String[] args){
        int n=5;int i=2;
        
        if(( n & (1 << (i-1)))==1){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        
    }
}
