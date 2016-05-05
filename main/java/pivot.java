import java.lang.Exception;
import java.util.Scanner;

public class pivot
{


  public static int fn(int arr[],int low,int high)
  {
   // System.out.println(low+": "+high);
    if(low==high)return low;
    int pos=low-1,i,temp,val=arr[high];
    for(i=low;i<=high;i++)
    {
      if(arr[i]<val)
      {
        pos++;
        temp=arr[pos];
        arr[pos]=arr[i];
        arr[i]=temp;
      }
    }
    pos++;
    temp=arr[pos];
    arr[pos]=arr[high];
    arr[high]=temp;
    return pos;
  }

  public static void qs(int arr[],int low,int high) throws Exception
  {
    if(high-low>=1)
    {
      int pv=fn(arr,low,high);
      qs(arr, low, pv - 1);
      qs(arr,pv+1,high);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int n,i,j,k;
    n=in.nextInt();
    int arr[] = new int[n];

     for(i=0;i<n;i++)
       arr[i]=in.nextInt();

    qs(arr,0,n-1);
      for(i=0;i<n;i++)
        System.out.print(arr[i]+" ");
      System.out.println();
    }

}