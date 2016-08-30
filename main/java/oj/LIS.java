import java.util.Scanner;

/**
 * Created by jayant.mukherji on 11/05/16.
 */
public class LIS {

  static  int len=100;
  static int ft[]= new int[len];

  //1 3 4 7
  static int fn(int l,int r,int arr[],int val)
  {
    int m;
    while(r-l>1)
    {
     m=l+(r-l)/2;
      //System.out.println(String.format("%d %d %d",l,r,m));
     if(arr[m]>val)r=m;
      else l=m;
    }
    return r;
  }


  static void put(int pos,int ele)
  {
    while(pos<=len)
    {
      ft[pos]+=ele;
      pos+=pos&(-pos);
    }
  }

  static int get(int pos)
  {
    int ans=0;
    while(pos>=0)
    {
      ans+=ft[pos];
      pos-=pos&(-pos);
    }
    return ans;
  }

  public static void main(String[] args) {

     int arr[]=new int[10000];
    int back[]=new int[10000];

    int len;
    Scanner in=new Scanner(System.in);
    len=in.nextInt();
    int temp[]=new int[len];
    int tail=-1,i;

    for(i=0;i<len;i++)
      arr[i]=in.nextInt();


    for(i=0;i<len;i++)
    {
      if(tail==-1)
      {
        temp[++tail]=arr[i];
      }
      else if(arr[i]<=temp[0])
      {
        temp[0]=arr[i];
      }
      else if(arr[i]>=temp[tail])
      {
        temp[++tail]=arr[i];
      }
      else
      {
        int pos=fn(0,tail,temp,arr[i]);
        System.out.println(arr[i]+" "+pos);
        temp[pos]=arr[i];
      }
    }
    for(i=0;i<=tail;i++)
      System.out.print(temp[i]+" ");

    System.out.println("\n"+tail);

//    while(in.hasNext())
//     System.out.println(fn(0, 4, arr, in.nextInt()));
  }
}
