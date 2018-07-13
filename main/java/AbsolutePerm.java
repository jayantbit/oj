import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jayant.mukherji on 22/05/16.
  https://www.hackerrank.com/contests/may-world-codesprint/challenges/absolute-permutation
 */
public class AbsolutePerm {

  public static void main(String[] args) {


    Scanner in = new Scanner(System.in);
    int tc,n,k,i,j;
    int arr[]= new int[100001];
    tc=in.nextInt();
    while(tc-->0)
    {
      n=in.nextInt();
      k=in.nextInt();
      int req=n;
      int flag=1;
      Arrays.fill(arr,0);
      for(i=1;i<=k && flag==1;i++)
      {
        int val=i+k;


        for(j=i;j<=n;j+=2*k)
        {

          if(val>n){
            flag=0;break;
          }
          arr[j]=val;
          val+=2*k;
        }
      }
      if(flag==1)
      {
        for(i=k+1;i<=n;i++)
        {
          if(arr[i]==0)arr[i]=i-k;
        }
      }

      if(flag==1) {
        for (i = 1; i <= n; i++) {
          if (i > 1) System.out.print(" ");
          System.out.print(arr[i]);
        }
      }
      else System.out.print("-1");

      System.out.println();
    }

  }
}
