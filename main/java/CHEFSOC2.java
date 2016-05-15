import java.util.Arrays;
import java.util.Scanner;

 class CHEFSOC2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int tc,n,m,s,i,j;
    tc=in.nextInt();
    long [][]dp =new long[1001][1001];
    while(tc-->0)
    {
      n=in.nextInt();
      m=in.nextInt();
      s=in.nextInt();


      int arr[]=new int[m+1];


      for(i=1;i<=m;i++)
      {
        arr[i]=in.nextInt();
      }

      for(i=0;i<=m;i++)
        Arrays.fill(dp[i],0);

      dp[0][s]=1;

      for(i=1;i<=m;i++)
      {
        for(j=1;j<=n;j++)
        {
          if(j-arr[i]>=1)
            dp[i][j]+=dp[i-1][j-arr[i]];

          if(j+arr[i]<=n)
            dp[i][j]+=dp[i-1][j+arr[i]];

          dp[i][j]%=1000000007;
          //System.out.print(dp[i][j]+" ");
        }
        //System.out.println();
      }

      for(j=1;j<=n;j++)
      {
        if(j>1) System.out.print(" ");
        System.out.print(dp[m][j]);
      }
      System.out.println();
    }
  }
}
