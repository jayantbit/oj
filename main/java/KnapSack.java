import java.util.*;
import java.util.stream.IntStream;
import java.lang.Math;



public  class KnapSack
{
  public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     int t =in.nextInt(),tc,i,j,k,n;
     for(tc=0;tc<t;tc++)
     {
       n=in.nextInt();
       k=in.nextInt();
       int arr[] =new int[n];
       int dp[][] = new int[n][k+1];

       IntStream.range(0,n)
               .forEach(pos-> {
                 arr[pos]=in.nextInt();
               });


       for(i=0;i<n;i++)
        for(j=0;j<=k;j++)
        {
          if(arr[i]<=j)
            dp[i][j]=Math.max( (i>0)?dp[i-1][j]:0,arr[i]+dp[i][j-arr[i]]);
          else if(i>0)dp[i][j]=dp[i-1][j];
        }

       System.out.println(dp[n-1][k]);
     }

  }
}