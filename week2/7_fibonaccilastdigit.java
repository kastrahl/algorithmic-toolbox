import java.util.*;
public class fiboparsum
{
  private static long fiboparsum(long m,long n) 
  {
      long sum=0;
      int a=(int)(m % 60);
      int b=(int)(n % 60);
      if(b<a)
      b=b+60;
      
      long cur=0,next=1,temp;
      
           for (int i = 0; i <= b; i++) 
           {
               if(i>=a)
               {
                   sum+=cur;
                }
               temp=next;
               next=next+cur;
               cur=temp;
            }
           return (int)(sum%10);
        }
  public static void main(String args[]) 
  { 
      Scanner scanner = new Scanner(System.in);
      long n = scanner.nextLong();
      long m = scanner.nextLong();
     
    System.out.println(fiboparsum(n,m));
  }
}
