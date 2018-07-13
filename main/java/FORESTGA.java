import java.util.Scanner;


class FORESTGA {

  static long req,l,n;
  static double logReq;
  static long h[]=new long[100000];
  static long r[]=new long[100000];
  static long lim=(long)Math.pow(10,18);

  static long wood(long wk)
  {
    long amt=0;
    for(int i=0;i<n;i++)
    {

      if(wk>0 && r[i]>lim/wk)return req+1;
      long height=h[i]+r[i]*wk;
      assert (height>=0);
      if(height>=l)amt+=height;
      if(amt>req)break;
    }
    return amt;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
     n=in.nextInt();
     req =in.nextLong();
     l=in.nextLong();

    int i;
    for(i=0;i<n;i++)
    {
      h[i]=in.nextLong();
      r[i]=in.nextLong();
    }

    long low=0,high=(long)Math.pow(10,18),mid;
    do {
      mid=(low+high)/2;
      long w=wood(mid);
      //System.out.println(mid+ " "+w);
      if(w>=req)high=mid;
      else low=mid;
    }while(high-low>1);

    long ans;
    if(wood(low)>=req)ans=low;
    else ans=high;


    System.out.println(ans);
  }
}
