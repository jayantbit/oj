import java.util.Scanner;

/**
 * Created by jayant.mukherji on 18/05/16.
 */
public class BIT {

  static int ft[] =new int[100000],mx=10;

  static void put(int pos,int ele)
  {
    if(pos==0)return;

    while(pos<=mx)
    {
      System.out.println(pos);
      ft[pos]+=ele;
      pos+=pos&(-pos);
    }
  }

  static int get(int pos)
  {
    int ans=0;
    while(pos>0)
    {
      System.out.println(pos);
      ans+=ft[pos];
      pos-=pos&(-pos);
    }
    return ans;
  }

   //0 1 0 2 0 0 0 0 0
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int a,b,n=100,i;
    //n=in.nextInt();
    int arr[] = new int[n];
    int less[] =new int[n];

    while(in.hasNext())
    {
      a=in.nextInt();
      b=in.nextInt();
      if(a==1)put(b,1);
      else {

        System.out.println(get(b));
      }
    }

//    for(i=0;i<n;i++)
//    {
//      arr[i]=in.nextInt();
//      mx=Integer.max(mx,arr[i]);
//    }
//    for(i=n-1;i>=0;i--)
//    {
//       less[i]=get(arr[i]-1);
//       put(arr[i],1);
//    }

  }
}
