import java.util.Arrays;
import java.util.Collections; 
  
public class Main
{ 
    public static void main(String[] args) 
    { 
       
        int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};  // Our arr contains 8 elements 
  
        Arrays.sort(arr);  
        System.out.printf("Modified arr[] : %s \n", Arrays.toString(arr)); 


        int[] arr2 = {13, 7, 6, 45, 21, 9, 101, 102}; 
        Arrays.sort(arr2, 1, 5); 
        System.out.printf("Modified arr[] : %s \n", Arrays.toString(arr2)); 


        Integer[] arr3 = {13, 7, 6, 45, 21, 9, 2, 100};     
        Arrays.sort(arr3, Collections.reverseOrder());            // Sorts arr[] in descending order
        System.out.printf("Modified arr[] : %s \n", Arrays.toString(arr3)); 
    } 
   
}
