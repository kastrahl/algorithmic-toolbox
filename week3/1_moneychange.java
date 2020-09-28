import java.util.Scanner;
public class moneychange 
{
    private static int getChange(int totalcost) 
    {
        int totalcoins = 0, cost = 0;
        int[] coinvalue = {10, 5, 1};
        int max = 0 ;  // index pointing to next max denominations
        
        while (cost < totalcost) 
        {
            while (cost <= totalcost && (totalcost - cost) >= coinvalue[max]) 
            {
                cost = cost + coinvalue[max];
                totalcoins++;
            }
         max = max + 1;
        }      
        return totalcoins;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

