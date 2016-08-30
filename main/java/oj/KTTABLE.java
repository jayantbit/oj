import java.util.Scanner;

/**
 * Created by jayant.mukherji on 29/05/16.
 https://www.codechef.com/SNCKQL16/problems/KTTABLE
 */
class KTTABLE {

  public static void main(String[] args) {
   int t,n,i,j,k;
    Scanner in = new Scanner(System.in);
    t=in.nextInt();
    while(t-->0)
    {
      n=in.nextInt();
      int a[] = new int[n+1];
      int b[]=new int[n+1];
      for(i=0;i<n;i++)
        a[i]=in.nextInt();

      for(i=0;i<n;i++)
        b[i]=in.nextInt();

      int ans=0;
      for(i=0;i<n;i++)
      {
        int prev=0;
        if(i>0)prev=a[i-1];

        if(b[i]<=a[i]-prev)ans++;
      }
      System.out.println(ans);

    }
  }
}
