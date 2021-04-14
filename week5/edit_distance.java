import java.util.*;
import java.math.*;

class edit_distance 
{
  public static int EditDistance(String s, String t) 
  {
      int m=s.length(),n=t.length();
      if(m==0&&n!=0)
      return n;
      if(n==0&&m!=0)
      return m;
      if(m==0&&n==0)
      return 0;
      
      int[][] dp=new int[m+1][n+1];
      int i,j;
      
     /* //res(m,n) = res
      
      
      //if current char Same 
      // res(3,3)=res(2,2)+0 OR res(m,n)=res(m-1,n-1)+0   (matching)    move diagnolly and write it 
      
      //if current char not Same
      //res(3,3)=res(3,2)+1  OR res(m,n)=res(m,n-1)+1     (insert op)       moving left
      //res(3,3)=res(2,3)+1  OR res(m,n)=res(m-1,n)+1     (remove op)       moving upwards
      //res(3,3)=res(2,2)+1  OR res(m,n)=res(m-1,n-1)+1   (replace op)      moving diagnolly
      //min(insert,remove,replace)
      
      //in end last cell gives answer return res(m,n)  */
      
      for(i=0;i<=m;i++)
      {
          for(j=0;j<=n;j++)
          {
            if(i==0)
                dp[i][j]=j;
            else
            if(j==0)
                dp[i][j]=i;
            else
            if(s.charAt(i-1)==t.charAt(j-1))            //MATHCING CASE
                dp[i][j]=dp[i-1][j-1];
            else                                        //NOT MATCHING
                                                        
            dp[i][j] = 1 + Math.min( dp[i][j-1] /*INSERT OP*/  , Math.min( dp[i-1][j]/*REMOVE OP*/ , dp[i-1][j-1]/*REPLACE OP*/)) ;
          }
      }
      
    return dp[m][n];
  }
  
  
  
  
  public static void main(String args[]) 
  {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}