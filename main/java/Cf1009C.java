import java.util.Scanner;

public class Cf1009C {



  public static long distSum(int n)
  {
    long  sum=0;
    int i,j=n/2;
    for(i=0;i<n;i++)
    {
      sum=sum+  Math.abs(i-j);
    }
    return sum;
  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int n=in.nextInt();
    int m=in.nextInt();

    long ans=0;
    int i;
    long distSum=distSum(n);


    for(i=0;i<m;i++)
    {
      long x=in.nextInt();
      long d=in.nextInt();

      ans+=n*x;
      if(d>0)
      {
        ans+=  d*n*(n-1)/2;
      }
      else
      {
        ans+=d*distSum;
      }

    }

    System.out.println((double)ans/n);

  }
}
