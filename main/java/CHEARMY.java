import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by jayant.mukherji on 31/05/16.
 https://www.codechef.com/JUNE16/problems/CHEARMY
 */
class CHEARMY {

  public static void main(String[] args) {
   Scanner in = new Scanner(System.in);
    PrintWriter ps = new PrintWriter(System.out);

    int t=in.nextInt();
    long n,i,j,k,base;
    int arr[]={0,2,4,6,8};
    while(t-->0)
    {
      n=in.nextLong();
      k=0;base=1;
      /*
       0 2 4 6 8
       100
       68
       */

      while(base*5<n){
        k++;
        base*=5;
      }

      while(base>0)
      {
        long a=(n-1)/base;

        n-=a*base;
        base/=5;
        ps.print(arr[(int) a]);
      }
      ps.println();

    }
    ps.close();

  }
}
