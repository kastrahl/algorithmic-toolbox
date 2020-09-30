import java.util.*;
public class adrevenue
{
    private static long maxproduct(Integer[] ppc, Integer[] cpd) //ppc-payperclick , cpd- click per day
    {
    	long rev = 0;
    	int slots = ppc.length;

        Arrays.sort(ppc, Collections.reverseOrder());           //sorting in reverse order
    	Arrays.sort(cpd, Collections.reverseOrder());           //sorting in reverse order

        for (int i = 0; i < slots; i++)                //multiplying for every max product
        {
            rev += ((long)ppc[i] * cpd[i]);
    	}
        return rev;
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) 
        {
            a[i] = scanner.nextInt();
        }

        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) 
        {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxproduct(a, b));
    }

}
