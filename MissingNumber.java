
public class MissingNumber {
    public static int missing(int[] a,int n){
        int ans=0;
        
        for(int i=1;i<=n;i++){
            ans =ans ^ i;
        }
        for(int i=0;i<a.length;i++){
            ans=ans ^ a[i];
        }
     return ans;   
    }
    public static void main(String[] args){
        int a[] = { 1 ,3,4,5};
        int n=5;
        System.out.println(missing(a,n));
    }
}
