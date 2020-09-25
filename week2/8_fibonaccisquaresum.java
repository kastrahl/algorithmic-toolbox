import java.util.*;

public class FibonacciSumSquares 
{
    private static int fibosum(long n) 
    {
        int sum = 0,i=0;
        n = (int) (n % 60); 
        int cur = 0,next=1,temp=0;
        for ( i = 0; i < n; i++) 
        {
            temp = next;
            next = (cur + next) % 10;
            cur = temp;
        }
        sum = (cur * next) % 10;
        return sum;
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(fibosum(n));
    }
}
    
