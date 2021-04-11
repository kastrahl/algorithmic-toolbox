
import java.io.*;
import java.util.*;

public class Main 
{
    private static Random random = new Random();
    
    private static int[] partition3_v1(int[] a, int l, int r) 
    {
        int [] result = new int[2];
        int k = l;
        int i = -1;
        int pivot = a[l];

        for (int j = l + 1; j <= r; j++) 
        {
            if (a[j] > pivot) 
            continue;

            else 
            if (a[j] == pivot) 
            {
                a[++k] = swap(a[j], a[j] = a[k]);

            } 
            else 
            if (a[j] < pivot) 
            {
                a[++k] = swap(a[j], a[j] = a[k]);
                a[++i] = swap(a[k], a[k] =a[i]);
            }
        }
        result[0] = i;
        result[1] = k+1;
        return result;
    }

    private static int[] partition3(int[] a, int l, int r) 
    {
        int i = l;      
        int j = r;
        int pivot = a[l]; 
        int[] result = {i, j};
        int k = l;
        while (k <= j) 
        {
            if (a[k] == pivot) 
            k++;
            
            else
            if (a[k] > pivot)
            {
                a[k] = swap(a[j], a[j] = a[k]);
                j--;
            }
            
            else 
            if (a[k] < pivot) 
            {
                a[k] = swap(a[i], a[i] = a[k]);
                k++;
                i++;
            }
            
            result[0] = i;
            result[1] = j;
        }
        return result;
    }

    private static int partition2(int[] a, int l, int r) 
    {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) 
        {
            if (a[i] <= x) 
            {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) 
    {
        if (l >= r) 
        {
            return;
        }
        if (r - l <= 1) 
        {
            if (a[l] > a[r]) 
            {
                a[l] = swap(a[r], a[r] = a[l]);
            }
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        
        //use partition3
        int[] m = partition3(a, l, r);
        
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    private static int swap(int a, int b) 
    {
        return a;
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
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) 
        {
            System.out.print(a[i] + " ");
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
                } catch (IOException e) {
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
