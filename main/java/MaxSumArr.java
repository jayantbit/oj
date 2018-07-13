import java.util.Scanner;

/**
 * Created by jayant.mukherji on 29/05/16.
 */

class MaxSumArr {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t,n,i,j,k;
    t=in.nextInt();
    while(t-->0)
    {
      n=in.nextInt();
      long arr[]=new long[n+1];

      long mx=0;
      for(i=0;i<n;i++)
      {
        arr[i]=in.nextLong();
        if(i==0)mx=arr[i];
        else mx=Math.max(mx,arr[i]);
      }

      long ans=0,a1=0,a2=0;
      if(mx<=0)ans=mx;
      else {
        for(i=0;i<n;i++)
        {
          a2=Math.max(a1,a2+arr[i]);
          a1=Math.max(0,a1+arr[i]);
          ans=Math.max(ans,Math.max(a1,a2));
        }
      }

      System.out.println(ans);
    }
  }
}
