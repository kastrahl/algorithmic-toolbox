import java.io.*;
import java.util.*;

public class BinarySearch 
{

    static int binarySearch(int[] a,int low,int high, int key) 
    {
        if(high<low)
           return -1;                                //return -1 if empty array
           
        int mid=( low + (high-low)/2);                    //calculating mid

        if(key==a[mid])                                    //if key found at mid
            return mid;
        if(key<a[mid])                                    //if key less than mid element
            return binarySearch(a, low, mid-1, key);
        else                                              //if key more than mid element
        if(key>a[mid])
            return binarySearch(a,mid+1, high, key);
        else 
            return -1;

    }

    static int linearSearch(int[] a, int x) 
    {
        for (int i = 0; i < a.length; i++) 
        {
            if (a[i] == x) return i;
        }
        return -1;
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
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) 
        {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) 
        {
            System.out.print(binarySearch(a,0,a.length-1,b[i]) + " ");      //a is array, 0 is low, high is length-1 , b[i] is key              
        }
    }
    static class FastScanner 
    {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) 
        {
            try 
            {
                br = new BufferedReader(new InputStreamReader(stream));
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }

        String next() 
        {
            while (st == null || !st.hasMoreTokens()) 
            {
                try 
                {
                    st = new StringTokenizer(br.readLine());
                }
                 catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() 
        {
            return Integer.parseInt(next());
        }
    }
}