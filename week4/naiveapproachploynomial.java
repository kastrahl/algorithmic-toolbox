import java.util.*;
import java.io.*;

public class naive
{
    public multpoly(int[] A,int[] B,int n)
    {
        int i=0,j=0;
        int[] product=new int[2*n-1];
        for(i=0;i<=n-1;i++)
        {
            for(j=0;j<=n-1;j++)
            {
                product[i+j]=product[i+j] + A[i]*B[j];
            }
        }
        return product;
    }

    public multy2(int[] A,int[] B,int n,int a,int b)
    {
        int i=0, j=0, d0e1=0, d1e0=0;

        int[] R = new int[2*n-1];
        if(n=1)
        {
            R[0] = A[a] *B[b] ;
            return R;
        }
        for(i=0;i<=n-2;i++)
        {
            R[i]=multy2(A,B,n/2,a,b);
        }
        for(j=n;j<=2*n-2;j++)
        {
            R[j]=multy2(A, B, n/2 ,a + n/2 ,b + n/2);
        }
        d0e1 = multy2(A,B,n/2,a,b+n/2);
        d1e0 = multy2(A,B,n/2,a+n/2,b);
        for( k=n/2 ; k<=n+n/2-2 ; k++)
        {
            R[k]+=d0e1+d1e0;
        }
    }

}
