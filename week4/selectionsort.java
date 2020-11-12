import java.util.*;
import java.io.*;

public class Main
{
    void selectionsort(int[] arr)
    {
        int n=arr.length;
        int i,minind,j;
        for(i=0;i<n;i++)
        {
            minind=i;
            for(j=i+1;j<n;j++)
            {
                if(arr[j]<arr[minind])
                {
                    minind=j;
                }
            }
            int temp = arr[minind]; 
            arr[minind] = arr[i]; 
            arr[i] = temp;
        }
    }

    void swap(int originelement,int newelement)
    {
        int temp;
        temp=originelement;
        originelement=newelement;
        newelement=temp;
    }

    void printarray(int[] arr)
    {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) 
    {
        System.out.println("enter number of elements of array");
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        System.out.println("enter elements of array");
        for (int i = 0; i < n; i++) 
        {
            numbers[i] = scanner.nextInt();
        }
        Main two = new Main();
        two.selectionsort(numbers);
        two.printarray(numbers);
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
