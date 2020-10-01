import java.util.*;
public class fibosum
{
  private static long seqlength(int m)
  {
      int cur=1,prev=0,l=1;
      while (true)
      {
        int tmp = prev;
        prev = cur;
        cur = (tmp + cur) % m;
        if (prev == 0 && cur == 1)
            break;
        l++;
        }
      return l;
      
  }
  private static int fibofast(long n) 
  {
    if (n == 1)
            return 1;
    else
       {
           int limit = (int) (n % seqlength(10));
           if (limit <= 0)
        	return 0;
           int a = 0,b=1,c=0,sum=1;
           for (int i = 1; i <= limit-1; i++) 
           {
              c = (a+b)%10;
              a = b;
              b = c % 10;
              sum=(sum+c)%10;
           }
           return sum;
       }
   }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    System.out.println(fibofast(n));
  }
}
