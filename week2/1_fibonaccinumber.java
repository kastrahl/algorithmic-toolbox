import java.util.Scanner;

public class Main
{
  private static long calc_fib(int n) 
  {
      int i,a=0,b=1,c=0;
    if (n == 1)
      return 1;
    if (n == 2)
      return 2;
      else
     
      {
          for (i=1;i<=n-2;i++)
          {
              c=a+b;
              a=b;
              b=c;
              
          }
          return c;
      }
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
