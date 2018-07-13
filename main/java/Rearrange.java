import java.util.*;
import java.util.stream.IntStream;


/*
2 1 0
0 1 2

4 0 1 2 3

3 4 0 1 2

4 3
3 2
2 1
1 0
0 4

arr[i] arr[arr[i]]
*/

public class Rearrange
{
  public static void main(String[] args) {
    Scanner in =new Scanner(System.in);
    int n= in.nextInt(),i,j,k;
    int arr[]=new int[n];
    IntStream.range(0,n)
             .forEach(pos->{
               arr[pos]=in.nextInt();
             });

    int temp=100;
    for(i=0;i<n;i++)
    {
     if(arr[i]<temp)
     {
       int newval=arr[arr[i]];
       if (newval>temp)newval/=temp;
       arr[i]=arr[i]*temp+newval;
     }
    }

    for(i=0;i<n;i++)
      System.out.print(arr[i]%temp + " ");
  }
}