import java.util.Scanner;

/**
 * Created by jayant.mukherji on 15/05/16.
 */

class CHEFMATH {

  static int lim=42;
  static long fib[]=new long[lim+1];
  static int MOD=1000000007;
  static long ans;

  static void ways(long x,int pos,int k)
  {
    if(k==0){
      if(x==0)
      {
        ans=(ans+1)%MOD;
      }
      return;
    }
    if(pos<0)return;

    if(k*fib[pos]<x)return;

    ways(x,pos-1,k);

    if(fib[pos]<=x)
      ways(x-fib[pos],pos,k-1);


  }
  //1 2 3 5 8 13 21
  /*

   2 3 8
   3 5 5
   2 3 8
   3 5 5
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int i, tc;
    fib[0] = 1;
    fib[1] = 2;

    for (i = 2; i <= lim; i++)
      fib[i] = fib[i - 1] + fib[i - 2];


    tc = in.nextInt();
    while (tc-- > 0) {
      ans=0;
      long target=in.nextInt();
      int k= in.nextInt();
      ways(target, 42, k);
      System.out.println(ans);
    }
  }
}
