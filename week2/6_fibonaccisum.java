import java.util.Scanner;

public class fibonaccisum
{
  private static long calc_fib(int n) 
  {
      int i,a=0,b=1,c=0,sum=1;
    if (n == 1)
      return 1;
    else
    if (n == 2)
      return 1;
    else
     
      {
          for (i=1;i<=n-1;i++)
          {
              c=(a+b)%10;
              a=b;
              b=c%10;
              sum =(sum+c)%10;
          }
          return sum;
      }
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
