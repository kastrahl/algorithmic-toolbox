import java.util.*;
import java.io.*;
class quicksort
{
    void quick(int[] arr, int l, int r)
    {
        int m;
        if(l>=r)
            return;
        m=partition(arr,l,r);
        quick(arr, l, m-1);
        quick(arr, m+1, r);    
    }
    int partition(int[]arr, int l, int r)
    {
        int x=arr[l];
        int j=l,i;
        for(i=l+1;i<=r;i++)
        {
            if(arr[i]<=x)
            {
                j=j+1;                      //red region counter increased to include element to be swapped with newfound less than 'x'
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp;              //swap the more than'x' element included in red region above with the new found less than 'x'
            }
        } 
        int temp2=arr[j];
        arr[j]=arr[l];
        arr[l]=temp2;                         //move the pivot to its partition position
        return j;
    }
    void printarray(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr.toString());
        }
    }

     public static void main(String[] args) 
    {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) 
        {
            numbers[i] = scanner.nextInt();
        }
        quicksort two = new quicksort();
        two.quick(numbers,0,numbers.length-1);
        System.out.println(Arrays.toString(numbers));
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
