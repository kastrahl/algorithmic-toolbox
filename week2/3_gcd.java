
import java.util.*;

public class GCD
{
  private static int gcd_naive(int a, int b) 
  {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) 
    {
      if (a % d == 0 && b % d == 0) 
      {
        if (d > current_gcd) 
        {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }
  private static int gcd_euclid(int a,int b)
  {
      int rem;
      rem=a%b;
      while(rem!=0)
          {
              a=b;
              b=rem;
              rem = a%b;
              
              
            }
      return b;
      
  }
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    
    if(b>a)
      {
          a = a + b; 
          b = a - b; 
          a = a - b;
      }
    System.out.println(gcd_euclid(a, b));
  }
}
