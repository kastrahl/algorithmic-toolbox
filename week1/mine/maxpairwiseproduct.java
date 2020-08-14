import java.util.*;
import java.io.*;

public class maxpairwiseproduct 
{
    static long getMaxPairwiseProduct(int[] num) 
    {
        int n = num.length;
        long max1 = 0;
        long max2 = 0;
         if (n==2)
          {
              long max_pro = Long.valueOf(num[0])*Long.valueOf(num[1]);
              return max_pro;
              
          }
         else
        	{
        	   for(int i = 0;i<n;i++)
        	  {
        		if(Long.valueOf(num[i])>=max1)
        		{
        		    max2 = max1;
        			max1 = num[i];
        			}
        		else
        		if(Long.valueOf(num[i])>max2)
        		  {max2=num[i];}
        	  }
        		  
            	long max_pro= max1*max2; 
            	return max_pro;
        	  
        	    
        	}
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
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
