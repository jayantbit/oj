
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Code {


  static int solve(int n)
  {
    long dp[][]= new long[n+1][5];

    long mod=1000000007;


    int i,j,k;

    for(i=0;i<5;i++)
      dp[0][i]=1;


    for(i=1;i<=n;i++)
    {
      for(j=0;j<5;j++)
        for(k=0;k<=j;k++)
        {
          dp[i][j]=  (dp[i][j]+dp[i-1][k])%mod;
        }
    }

    Map<String,Integer> map = new HashMap<>();
    List<String> list = new ArrayList<String>();

   for(Map.Entry entry : map.entrySet())
   {

   }


    long ans=0;

    for(j=0;j<5;j++)
      ans= (ans+dp[n-1][j])%mod;

    return (int)ans;
  }


  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int x=24;
    double res=24;
    System.out.println(String.format("%.3f",res));

  }
}
