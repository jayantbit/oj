import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jayant.mukherji on 15/05/16.
 */

class CHEFMATH {

  static int lim=42;
  static int fib[]=new int[lim+1];
  static int MOD=1000000007;

  static class Rem
  {
    int x,k,up;
    Rem(int a,int b,int c)
    {
      x=a;
      k=b;
      up=c;
    }
  }

  static HashMap<Rem,Long> mp =new HashMap();

  static long ways(int x,int k,int up)
  {
    if(k==0)return (x==0)?1:0;
    long ans=0;
    int i;
    if(k==1)
    {
      for(i=0;i<=up;i++)
        if(fib[i]==x)return 1;
      return 0;
    }

    Rem rem=new Rem(x,k,up);
    if(mp.containsKey(rem))
      return mp.get(rem);

    for(i=0;i<=up;i++)
    {
      if(fib[i]<=x)
        ans=(ans+ways(x-fib[i],k-1,i))%MOD;
      else break;
    }
    mp.put(rem,ans);
    return ans;
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

    int i,tc;
    fib[0]=1;
    fib[1]=2;
    for(i=2;i<=lim;i++)
    {
      fib[i]=fib[i-1]+fib[i-2];
      System.out.println(fib[i]);
    }

    tc=in.nextInt();
    while(tc-->0)
      System.out.println(ways(in.nextInt(),in.nextInt(),lim));

  }
}
