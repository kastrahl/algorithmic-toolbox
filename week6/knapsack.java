import java.util.*;
import java.math.*;

public class knapsack
{
    static int optimalWeight(int capacity, int[] w)
    {
        int numberofbars=w.length;
        int[][] maxgold=new int[capacity+1][numberofbars+1];    //int[rows][column]
        int weight=0,i=0;
        
        for (weight = 0; weight <= capacity; weight++) 
        {
            for (i = 0; i<= numberofbars; i++) 
            {
                if (i == 0 || weight == 0)      //if 0 capacity and 0 bars (BORDER CASE)
                {
                    maxgold[weight][i] = 0; 
                }
                else
                {
                    int notuselement = maxgold[weight][i-1];

                    int useelement =0;

                    if (weight - w[i-1] >= 0)           //if enough weight & ith Item's weight is w[i-1]
                    {
                        useelement = maxgold[weight - w[i-1]][i-1] + w[i-1];
                    }

                    maxgold[weight][i] = Math.max(useelement, notuselement);
                }
            }
        }
        return maxgold[capacity][numberofbars];
        
    /*  int[] value=new int[];
        value[0]=0;
        int w=0;
        for(w=1;w<W;w++)
        {
            value[w]=0;
            for(i=1;i<n;i++)
            {
                
            }
        }*/
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();              //capacity weight
        n = scanner.nextInt();              //number of bars (ex= 3 bars)
        int[] w = new int[n];               //weight of respective gold bars
        for (int i = 0; i < n; i++) 
        {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}