
public class PrintSubset {
    public static void main(String[] args){
        int n=4;
        int a[]={1,2,3,4};
        
        int total= 1<<n;
        for(int k=1;k<total;k++){
            for(int i=0;i<n;i++){
                if(( k & (1 << (i)))==1){
                    System.out.print(a[i]+"");
                }
            }
            System.out.println("");
        }
    }
}
