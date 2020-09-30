
public class XORSN {
    public static int getXor(int n){
        
        switch(n%4){
            case 0 : return n;
            case 1 : return 1;
            case 2:  return n+1;
            case 3 : return 0;
        }
        return 0;
    }
    public static void main(String[] args){
        System.out.println(getXor(6));       
           }
}
