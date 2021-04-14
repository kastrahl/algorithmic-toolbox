import java.util.*;
public class primitive_calculator 
{
    private static List<Integer> optimal_sequence(int n) 
    {
        List<Integer> sequence = new ArrayList<>();

        int[] arr = new int[n + 1];
        arr[0]=0;

        for (int i = 1; i < arr.length; i++) 
        {
            arr[i] = arr[i - 1] + 1;
            
            if (i % 2 == 0) 
                arr[i] = Math.min(1 + arr[i / 2], arr[i]);
                
            if (i % 3 == 0) 
                arr[i] = Math.min(1 + arr[i / 3], arr[i]);
        }
        for (int i = n; i > 1; ) 
        {
            sequence.add(i);
            
            if (arr[i - 1] == arr[i] - 1)
                i = i - 1;
                
            else 
            if (i % 2 == 0 && (arr[i / 2] == arr[i] - 1))
                i = i / 2;
                
            else 
            if (i % 3 == 0 && (arr[i / 3] == arr[i] - 1))
                i = i / 3;
        }
        
        sequence.add(1);
        Collections.reverse(sequence);
        return sequence;
    }
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) 
        {
            System.out.print(x + " ");
        }
    }
}