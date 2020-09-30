
public class LonelyInteger {
    public  static int lonelyinteger(int[] a) {
           int ans =0;
           for(int i=0;i<a.length;i++){
               ans = ans ^ a[i];
           }
           return ans;

    }
    public static void main(String[] args){
        int a[]={4,3,1,3,1};
        System.out.println(lonelyinteger(a));
    }
}
