import java.util.Scanner;

public class Main 
{
    private static double getOptimalValue(int capacity, int[] values, int[] weights) 
    {

        double value = 0;                                                             //value is V
        int n = values.length;
        
        double perunit[] = new double[capacity];
        
        for (int i=0; i < n ; i++)
        {
            perunit[i]=(values[i]*1.0/weights[i]);
        }
        
        Main ob = new Main(); 
        ob.sort(perunit, 0, perunit.length - 1,values,weights);

        int counter=0,len=perunit.length;                                             //len for whole length

        for (int i = 0; i < n; i++) 
        {
            if (capacity <= 0)                                                        //capacity is W
                return value;

            int taken = Math.min(capacity, values[len-1-i]);
            value += (taken * (values[len-1-i] * 1.0) / weights[len-1-i]);
            capacity -= taken;
        }
        return value;
    }
    
    void merge(double perunit[], int l, int m, int r,int value[],int weight[]) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        double L[] = new double[n1]; 
        double R[] = new double[n2]; 
        int tempvalueL[]  =new int[n1];
        int tempvalueR[]  =new int[n2];
        int tempweightL[] =new int[n1];
        int tempweightR[] =new int[n2];
            
            for (int i = 0; i < n1; ++i) 
               {
                L[i]          = perunit[l + i]; 
                tempvalueL[i] = value[l + i];
                tempweightL[i]= weight[l + i];
               } 
        
            for (int j = 0; j < n2; ++j) 
                {
                    R[j]          = perunit[m + 1 + j];
                    tempvalueR[j] = value[m+1+j];
                    tempweightR[j]= weight[m+1+j]; 
                }
    
        int i = 0, j = 0; 
        int k = l; 
    
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                perunit[k] = L[i];
                value[k]  =tempvalueL[i];
                weight[k] =tempweightL[i]; 
                i++; 
            } 
            else 
            { 
                perunit[k] = R[j]; 
                value[k] = tempvalueR[j];
                weight[k]=tempweightR[j];
                j++; 
            } 
            k++; 
        } 
    
        while (i < n1) 
        { 
            perunit[k] = L[i]; 
            value[k]  =  tempvalueL[i];
            weight[k] = tempweightL[i];
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
            perunit[k] = R[j]; 
            value[k]  =  tempvalueR[j];
            weight[k] = tempweightR[j];
            j++; 
            k++; 
        } 
    } 
    void sort(double perunit[], int l, int r,int value[],int weight[]) 
    { 
        if (l < r) 
        { 
            int m = (l + r) / 2; 
            sort(perunit,  l     , m , value , weight);       //calling for firsthalf
            sort(perunit,  m + 1 , r , value , weight);       //calling for second half
            merge(perunit, l , m , r , value , weight); 
        } 
    }

    public static void main(String args[]) 
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) 
        {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
