import java.util.*;
import java.io.*;

public class Main 
{
    private static int getMajorityElement(int[] a, int left, int right) 
    {
        if (left == right) 
        {
            return 0;
        }
        if (left + 1 == right) 
        {
            return a[left];
        }
        //write your code here
        return 0;
    }
    private static int majority(int[] arr)
    {
        long max=0,max2=0;
        int n = arr.length,i,j;
        if(n<0)                                 //if empty array
            return 0;

        for( j=0 ; j<n ; j++ )                  //max element to make array of counting
        {
            if(arr[j]>=max)
            max=arr[j];
        }
        long[] count = new long[(int)max+1];
        for(i = 0 ; i < n; i++)                 //counting occurence of each elements number of times (thus loop runs number of inputs times)
        {
            ++count[arr[i]] ;                   //increase count by one of element A[i] ,example (++count[4]-> makes count go from maybe 0 to 1 )
        }
        for( j=0 ; j<max ; j++ )                  //max element to make array of counting
        {
            if(count[j]>=max2)
            max2=count[j];
        }
        if(max2>n/2)
        return 1;
        else 
        return 0;
    }

    public static void main(String[] args) 
    {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) 
        {
            a[i] = scanner.nextInt();
        } 
        System.out.println(majority(a));
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
