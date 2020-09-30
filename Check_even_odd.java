
import java.util.Scanner;


public class Check_even_odd {
     
    public static boolean check(int num){
        
        return((num & 1)!=1);
    }
     public static void main(String[] args) {
         
       int num=5;
       Check_even_odd c =new Check_even_odd();
       c.check(num);
       System.out.println(check(num)==true ? "Even":"ODD");
         
}
}