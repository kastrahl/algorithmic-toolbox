import java.util.*;
public class fibonaccihuge
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
  private static int fibofast(long n, int m) 
  {
    if (n == 1|| n == 2)
            return 1;
    else
       {
           int limit = (int) (n % (long)seqlength(m));
           if (limit <= 0)
        	return 0;
           int a = 0;
           int b = 1;
           int c;
           for (int i = 1; i <= limit-1; i++) 
           {
              c = a;
              a = b;
              b = (c + b) % m;
           }
           return b;
       }
   }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    int m = scanner.nextInt();
    
    System.out.println(fibofast(n, m));
  }
}
