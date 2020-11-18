import java.util.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;


public class majority3
{
    private static int major(int[] arr)
    {
        int n=arr.length;
        randompivotquick(arr,0,n-1);
        int pcount=1;
        long pelement=arr[0];
        int mcount=1;
        long melement=arr[0];
        for(int i=1 ; i<arr.length ; i++)
        {
            if(pelement==arr[i])
            {
                ++pcount;
            }
            else
            {
                if(pcount>mcount)
                {
                    mcount=pcount;
                    melement=pelement;
                }
                pelement=arr[i];
                pcount=1;
                
            }
        }
        if(pcount>mcount)
                {
                    mcount=pcount;
                    melement=pelement;
                }
        if(mcount>n/2)
            return 1;
        else
            return -1;
    }
    private static void randompivotquick(int[] arr2,int l, int r)
    {
        int m;
        if(l>=r)
            return;
        int k=ThreadLocalRandom.current().nextInt(l, r + 1);       //choosing random pivot

        int temp = arr2[l];                                        //swapping A[l]=A[k]
        arr2[l]=arr2[k];
        arr2[k]=temp;

        m=partition(arr2,l,r);
        randompivotquick(arr2, l, m-1);
        randompivotquick(arr2, m+1, r);
    }
    private static int partition(int[]arr, int l, int r)
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
    private static int getMajorityElementNonRecursive(int[] a) 
    {
    	Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
    	int ans = -1;

        for (int i = 0; i < a.length; i++) 
        {
    		frequency.put(a[i], frequency.getOrDefault(a[i], 0) + 1);
    	}

        for (int key : frequency.keySet())
        {
    		int value = frequency.get(key);
            if (value > a.length / 2) 
            {
    			ans = value;
    			break;
    		}
    	}
    	return ans;
    }
    static void stressTest() 
    {
    	Random r = new Random();

    	int n = 10;
        int[] a = new int[n];
        while (true) 
        {
            for (int i = 0; i < n; i++) 
            {
	            a[i] = r.nextInt(5);
	        }
            
            int result1 = getMajorityElementNonRecursive(a) != -1 ? 1 : 0;
            int result2 = major(a) != -1 ? 1 : 0;
            
            if (result1 != result2) 
            {
                for (int i = 0; i < n; i++) 
                {
	        		System.out.printf("%d ", a[i]);
	        	}
	        	System.out.println();
	        	System.out.printf("Correct Answer: %d\n", result1);
	        	System.out.printf("Found Answer  : %d\n", result2);
	        	break;
	        }
	        System.out.println("Correct");
        }
    }

    public static void main(String[] args) 
    {
        stressTest();
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) 
        {
            a[i] = scanner.nextInt();
        }
        System.out.println(major(a));
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
