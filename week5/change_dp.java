import java.util.Scanner;

public class ChangeDP
{
    private static int getChange(int m) 
    {
        int[] denom = {1,3,4};
        int[] denomcount = new int[m+1];
        denomcount[0]=0;
        for (int i = 1; i<=m ;i++) 
        {
            denomcount[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i <= m; i++) 
        {
            for (int j = 0; j < denom.length; j++) 
            {

                if (i-denom[j] >= 0) 
                {
                    denomcount[i] = Math.min(denomcount[i], denomcount[i-denom[j]] + 1);
                    
                }
            }
        }
        return denomcount[m];
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
