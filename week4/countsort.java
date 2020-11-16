import java.util.*;
import java.io.*;
class countsort
{
    void count(int[] A )
    {
        int i,j,max=0;
        int n = A.length;

        for( j=0 ; j<n ; j++ )                   //max element to make array of counting
        {
            if(A[j]>=max)
            max=A[j];
        }
        int[] count=new int[max];
        int[] pos=new int[n];

        for(i = 0 ; i < n; i++)                //counting occurence of each elements number of times (thus loop runs number of inputs times)
        {
            ++count[A[i]] ;                    //increase count by one of element A[i] ,example (++count[4]-> makes count go from maybe 0 to 1 )
        }
        for(i = 1; i <= max; i++)              //modifying count to include previous elements count as well(thus loop runs till max element inputted)
        {
            count[i] += count[i - 1];           
        }
        for(i=0; i < n-1 ; i++)                 //total elements= n,thus loop runs n-1 times eventhough "count" has man elements but those elements are counts
        {
            pos[count[A[i]] - 1] = A[i];        
            --count[A[i]];
        }
        for ( i = 0; i < n; ++i) 
        {
            A[i] = pos[i];
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
        countsort two = new countsort();
        two.count(numbers);
        for(i=0 ; i<n ; i++)
        System.out.println(numbers[i]);
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
