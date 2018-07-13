import java.util.Scanner;

/**
 * Created by jayant.mukherji on 04/06/16.
 https://www.codechef.com/JUNE16/problems/CHEFARK
 MOD INV
 */

class CHEFARK {

  static final long MOD=1000000007;
  static final int LIM=100000;
  static long fact[]=new long[LIM+1];
  static long factInv[]=new long[LIM+1];
  static long modInverse[]=new long[LIM+1];

  public static void fn()
  {
    fact[0]=1;
    int i;
    for(i=1;i<=LIM;i++)
    fact[i]=(i*fact[i-1])%MOD;

    modInverse[1] = 1;
    modInverse[0]=1;

    for( i = 2; i <= LIM; i++)
      modInverse[i] = (-(MOD/i) * modInverse[(int)MOD % i]) % MOD + MOD;


    factInv[0]=factInv[1]=1;
    for(i=2;i<=LIM;i++){
      factInv[i]=(modInverse[i]*factInv[i-1])%MOD;
    }
  }

  public static long NCR(int n,int r)
  {
    long a=fact[n];
    long b=(factInv[r]*factInv[n-r])%MOD;
    return (a*b)%MOD;
  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    fn();

    int t,n,i,j,k;

//    for(i=0;i<=10;i++)
//    {
//      for(j=0;j<=i;j++)
//        System.out.print(NCR(i,j)+" ");
//      System.out.println();
//    }
    t=in.nextInt();
    while(t-->0)
    {
      n=in.nextInt();
      k=in.nextInt();

      int nz=0;
      for(i=0;i<n;i++)
      {
        int num=in.nextInt();
        if(num!=0)nz++;
      }


      long ans=0;
      for(i=0;i<=k && i<=nz;i++)
      {
        if((k-i)%2==0 || nz!=n)ans=(ans+NCR(nz,i))%MOD;
      }

      System.out.println(ans);

    }
  }
}
