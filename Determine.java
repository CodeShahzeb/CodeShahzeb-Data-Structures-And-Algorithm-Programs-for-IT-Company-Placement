
public class Determine {
    public static void main(String[] args){
        int n=4;
        int a[]={1,2,3,3};
        
        int ans=0;
        for(int i : a){
            ans=ans ^i;
        }
        
        int pos=(int) Math.floor(Math.log10(ans)/Math.log10(2))+1;
        int y1=0;int y2=0;
        
        for(int i:a){
            if(( i & (1 << (pos-1)))==1){
                y1 ^=i;
            }
            else{
                y2 ^=i;
            }
        }
            System.out.println(y1 + "  " + y2);
    }
    }
