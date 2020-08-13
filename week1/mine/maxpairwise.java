import java.util.*;
import java.io.*;

public class Main {
    static long getMaxPairwiseProduct(int[] num) {
        int n = num.length;
        long max1 = 0;
        long max2 = 0;
        	for(int i = 0;i<n;i++)
        	{
        		if(num[i]>=max1)
        		{
        		    max2 = max1;
        			max1 = num[i];
        			}
        	}
        	long max_pro= max1*max2; 
        return max_pro;
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
